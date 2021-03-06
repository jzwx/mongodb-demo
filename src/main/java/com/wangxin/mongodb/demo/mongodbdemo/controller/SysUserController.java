package com.wangxin.mongodb.demo.mongodbdemo.controller;

import com.wangxin.mongodb.demo.mongodbdemo.domain.SysUser;
import com.wangxin.mongodb.demo.mongodbdemo.domain.UserCount;
import com.wangxin.mongodb.demo.mongodbdemo.service.impl.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:jzwx
 * @Desicription: SysUserController
 * @Date:Created in 2018-08-15 10:38
 * @Modified By:
 */
@Controller
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * mongodb jpa接口调用做数据库操作
     * @return
     */
    @RequestMapping(value = "/getByUserName", method = RequestMethod.GET)
    public @ResponseBody
    String getUserDetails() {
        sysUserService.save(new SysUser("jzwx", "123456", "2018-01-01 12:13:00", "2018-01-01 12:13:00", "1"));
//        sysUserService.save(new SysUser("xiaoxingxing", "123456", "2018-01-01 12:13:00", "2018-01-01 12:13:00", "1"));
//        sysUserService.save(new SysUser("xiaohaha", "123456", "2018-01-01 12:13:00", "2018-01-01 12:13:00", "2"));
//        sysUserService.save(new SysUser("hehe", "123456", "2018-01-01 12:13:00", "2018-01-01 12:13:00", "2"));
//        sysUserService.save(new SysUser("zhangsan", "123456", "2018-01-01 12:13:00", "2018-01-01 12:13:00", "1"));
//        List<SysUser> sysUsers = new ArrayList<>();
//        for (SysUser sysUser : sysUserService.findAll()) {
//            sysUsers.add(sysUser);
//            System.out.println(sysUser.toString());
//        }
//
//        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
//
//        List<SysUser> sysUserList = sysUserService.findByType("1");
//        for (SysUser sysUser : sysUserList) {
//            System.out.println(sysUser.toString());
//        }
//
//        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
//
//        SysUser sysUser = sysUserService.findByUserName("jzwx");
//        System.out.println(sysUser.toString());
        return "ok";
    }

    /**
     * mongodb分页查询 使用mongodb jpa做接口查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getAllUserInfo", method = RequestMethod.GET)
    public @ResponseBody Page<SysUser> getAllUserInfo(@RequestParam(value = "pageNumber", required = true) int pageNumber,
                                        @RequestParam(value = "pageSize", required = true) int pageSize) {
        //构建分页信息
        PageRequest pageRequest = buildPageRequest(pageNumber,pageSize,"auto");
        Page<SysUser> sysUsers = sysUserService.findByTypePage("1",pageRequest);
        return sysUsers;
    }

    private PageRequest buildPageRequest(int pageNumber, int pageSize,String sortType){
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "id");
        } else if ("birthday".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "birthday");
        }
        //参数1表示当前第几页,参数2表示每页的大小,参数3表示排序
        return new PageRequest(pageNumber-1,pageSize,sort);
    }

    /**
     * mongodb模板做查询
     * @return
     */
    @RequestMapping(value = "/queryListUserInfo", method = RequestMethod.GET)
    public @ResponseBody
    String queryListUserInfo() {
        List<SysUser> sysUser = sysUserService.queryListUserInfo("1");
        System.out.println(sysUser.toString());
        return sysUser.toString();
    }


    /**
     * 聚合查询
     * @return
     */
    @RequestMapping(value = "/tongji", method = RequestMethod.GET)
    public @ResponseBody
    String tongji() {
        List<UserCount> userCount = sysUserService.getUserCount();
        System.out.println(userCount.toString());
        return userCount.toString();
    }

    /**
     * 注解查询
     * @return
     */
    @RequestMapping(value = "/zhujie", method = RequestMethod.GET)
    public @ResponseBody
    String zhujie() {
        List<SysUser> sysUsers = sysUserService.getUserInfoByZhuJie();
        System.out.println(sysUsers.toString());
        return sysUsers.toString();
    }
}