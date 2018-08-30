package com.wangxin.mongodb.demo.mongodbdemo.service;

import com.wangxin.mongodb.demo.mongodbdemo.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @Author:jzwx
 * @Desicription: 用户仓储接口
 * @Date:Created in 2018-08-15 9:48
 * @Modified By:
 */
public interface SysUserRepository extends MongoRepository<SysUser, String> {
    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    SysUser findByUserName(String userName);

    /**
     * 根据类型获取到所有用户信息
     *
     * @param type
     * @return
     */
    List<SysUser> findByTypeOrderByGmtCreateDesc(String type);

    /**
     * 根据用户类型分页查询用户信息列表
     *
     * @param type
     * @param pageable
     * @return
     */
    Page<SysUser> findByType(String type, Pageable pageable);


    /**
     * @param type
     * @return
     * @Query中给定的JSON将会与所有的Order文档进行匹配，并返回匹配的文档，这里的type属性映射成“？0”，这表明type属性应该与查询方法的第0个参数相等，如果有多个参数，则"?1".....
     */
    @Query("{'type':?0}")
    List<SysUser> findUserInfos(String type);
}