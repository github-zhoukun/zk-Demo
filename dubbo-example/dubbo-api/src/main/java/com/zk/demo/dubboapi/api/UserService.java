package com.zk.demo.dubboapi.api;

import com.zk.demo.dubboapi.entity.UserInfo;
import com.zk.demo.dubboapi.param.UserParamInfo;

import java.util.List;

/**
 * User信息api
 */
public interface UserService {

    /**
     * 创建
     * @param userInfo
     */
    void create(UserInfo userInfo);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Long id);

    /**
     * 修改
     * @param userInfo
     */

    void update(UserInfo userInfo);

    /**
     * 查询
     * @param userParamInfo
     * @return
     */
    List<UserInfo> getAll(UserParamInfo userParamInfo);

    /**
     * 总条数
     * @param userParamInfo
     * @return
     */
    Integer getTotal(UserParamInfo userParamInfo);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    UserInfo getEntityById(Integer id);

    List<UserInfo> getUserByName(UserParamInfo userParamInfo);
}
