package com.wangxin.mongodb.demo.mongodbdemo.service.impl;

import com.wangxin.mongodb.demo.mongodbdemo.domain.SysUser;
import com.wangxin.mongodb.demo.mongodbdemo.service.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:jzwx
 * @Desicription: SysUserService
 * @Date:Created in 2018-08-15 10:31
 * @Modified By:
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;

    /**
     * 删除所有的客户
     */
    public void deleteAll(){
        sysUserRepository.deleteAll();
    }

    /**
     * 保存用户
     * @param sysUser
     */
    public void save(SysUser sysUser){
        sysUserRepository.save(sysUser);
    }

    /**
     * 查询所有用户列表
     * @return
     */
    public Iterable<SysUser> findAll(){
        return sysUserRepository.findAll();
    }

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    public SysUser findByUserName(String userName){
        return sysUserRepository.findByUserName(userName);
    }

    /**
     * 根据用户类型获取用户列表信息降序排序
     * @param type
     * @return
     */
    public List<SysUser> findByType(String type){
        return sysUserRepository.findByTypeOrderByGmtCreateDesc(type);
    }

    /**
     * 根据用户类型分页查询用户信息列表
     * @param type
     * @param pageable
     * @return
     */
    public Page<SysUser> findByTypePage(String type, Pageable pageable){
        return sysUserRepository.findByType(type,pageable);
    }
}
