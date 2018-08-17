package com.wangxin.mongodb.demo.mongodbdemo.service;

import com.wangxin.mongodb.demo.mongodbdemo.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author:jzwx
 * @Desicription: 用户仓储接口
 * @Date:Created in 2018-08-15 9:48
 * @Modified By:
 */
public interface SysUserRepository extends MongoRepository<SysUser,String>{
    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    SysUser findByUserName(String userName);

    /**
     * 根据类型获取到所有用户信息
     * @param type
     * @return
     */
    List<SysUser> findByTypeOrderByGmtCreateDesc(String type);

    /**
     * 根据用户类型分页查询用户信息列表
     * @param type
     * @param pageable
     * @return
     */
    Page<SysUser> findByType(String type, Pageable pageable);
}
