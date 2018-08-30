package com.wangxin.mongodb.demo.mongodbdemo.domain;

/**
 * @Author:jzwx
 * @Desicription: UserCount
 * @Date:Created in 2018-08-29 17:08
 * @Modified By:
 */
public class UserCount {
    private String userName;

    private long total;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "UserCount{" +
                "userName='" + userName + '\'' +
                ", total=" + total +
                '}';
    }
}
