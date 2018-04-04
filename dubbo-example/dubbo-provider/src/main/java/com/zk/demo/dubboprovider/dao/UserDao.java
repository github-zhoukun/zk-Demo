package com.zk.demo.dubboprovider.dao;

import com.zk.demo.dubboapi.entity.UserInfo;
import com.zk.demo.dubboapi.param.UserParamInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserDao
 */
public interface UserDao extends BaseDao<UserInfo> {

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
    List<UserInfo> getAll(@Param("param")UserParamInfo userParamInfo);

    /**
     * 总条数
     * @param userParamInfo
     * @return
     */
    Integer getTotal(@Param("param") UserParamInfo userParamInfo);

    UserInfo getEntityById(Integer id);

    List<UserInfo> getUserByName(@Param("param")UserParamInfo userParamInfo);

}
