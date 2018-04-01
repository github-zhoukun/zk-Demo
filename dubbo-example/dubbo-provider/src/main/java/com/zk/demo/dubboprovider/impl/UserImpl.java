package com.zk.demo.dubboprovider.impl;

import com.github.pagehelper.PageHelper;
import com.zk.demo.dubboapi.api.UserService;
import com.zk.demo.dubboapi.entity.UserInfo;
import com.zk.demo.dubboapi.param.UserParamInfo;
import com.zk.demo.dubboprovider.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user接口实现
 */
@Service
public class UserImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public void create(UserInfo userInfo) {
        userDao.create(userInfo);
    }

    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    public void update(UserInfo userInfo) {
        userDao.update(userInfo);
    }

    public List<UserInfo> getAll(UserParamInfo userParamInfo) {
        PageHelper.startPage(userParamInfo.getPage(), userParamInfo.getRows());
        return userDao.getAll(userParamInfo);
    }
}
