package com.zk.demo.dubboprovider.impl;

import com.github.pagehelper.PageHelper;
import com.zk.demo.dubboapi.api.UserService;
import com.zk.demo.dubboapi.entity.UserInfo;
import com.zk.demo.dubboapi.param.UserParamInfo;
import com.zk.demo.dubboprovider.dao.UserDao;
import com.zk.demo.dubboprovider.dataSource.DynamicSwitchDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * user接口实现
 * @author zhoukun
 */
@Service
@DynamicSwitchDB(db = "zk")
public class UserImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void create(UserInfo userInfo) {
        userDao.create(userInfo);
    }
    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
    @Override
    public void update(UserInfo userInfo) {
        userDao.update(userInfo);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
    @Override
    public List<UserInfo> getAll(UserParamInfo userParamInfo) {
        PageHelper.startPage(userParamInfo.getPage(), userParamInfo.getRows());
        return userDao.getAll(userParamInfo);
    }

    @Override
    @DynamicSwitchDB(db = "zk")
    public Integer getTotal(UserParamInfo userParamInfo) {
        return userDao.getTotal(userParamInfo);
    }

    @Override
    public UserInfo getEntityById(Integer id) {
        return userDao.getEntityById(id);
    }

    @Override
    public List<UserInfo> getUserByName(UserParamInfo userParamInfo) {
        return userDao.getUserByName(userParamInfo);
    }
}
