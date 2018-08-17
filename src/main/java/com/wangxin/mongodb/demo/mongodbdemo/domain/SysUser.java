package com.wangxin.mongodb.demo.mongodbdemo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author:jzwx
 * @Desicription: SysUser
 * @Date:Created in 2018-08-15 8:46
 * @Modified By:
 */
@Document(collection = "sysuser")
public class SysUser {
    @Id
    private String id;

    private String userName;

    private String password;

    private String gmtCreate;

    private String gmtModified;

    private String type;

    public SysUser(){

    }

    public SysUser(String userName, String password, String gmtCreate, String gmtModified, String type) {
        this.userName = userName;
        this.password = password;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
