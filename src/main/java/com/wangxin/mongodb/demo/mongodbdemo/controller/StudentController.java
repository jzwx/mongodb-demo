package com.wangxin.mongodb.demo.mongodbdemo.controller;

import com.wangxin.mongodb.demo.mongodbdemo.domain.Student;
import com.wangxin.mongodb.demo.mongodbdemo.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:jzwx
 * @Desicription: StudentController
 * @Date:Created in 2018-08-30 10:02
 * @Modified By:
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    /**
     * 学生服务接口
     */
    @Autowired
    private StudentService studentService;

    /**
     * 新增学生
     * @return
     */
    @RequestMapping(value = "/save",method = {RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody String save(){
//        studentService.save(new Student("张三","男",25,"12300000021","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535605619979&di=76b284cedbd307223103620e26e5ac1a&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F12%2F88%2F66%2F36X58PICw9F.jpg"));
//        studentService.save(new Student("李四","男",35,"18800000021","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535605619979&di=76b284cedbd307223103620e26e5ac1a&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F12%2F88%2F66%2F36X58PICw9F.jpg"));
//        studentService.save(new Student("王五","男",16,"19900000021","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535605619979&di=76b284cedbd307223103620e26e5ac1a&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F12%2F88%2F66%2F36X58PICw9F.jpg"));
//        studentService.save(new Student("牛牛","男",30,"11212000021","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535605619979&di=76b284cedbd307223103620e26e5ac1a&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F12%2F88%2F66%2F36X58PICw9F.jpg"));
//        studentService.save(new Student("囡囡","女",16,"16600000021","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535605619979&di=76b284cedbd307223103620e26e5ac1a&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F12%2F88%2F66%2F36X58PICw9F.jpg"));
        studentService.save(new Student("糖心","女",18,"11122233344","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535605619979&di=76b284cedbd307223103620e26e5ac1a&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F12%2F88%2F66%2F36X58PICw9F.jpg"));
        return "save Success";
    }

    /**
     * 修改学生信息
     * @return
     */
    @RequestMapping(value = "/updateInfo",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody String updateInfo(){
        List<Student> studentList = studentService.getAllStudent();
        String id = studentList.get(0).getId();
        Student student = studentService.getStudent(id);
        System.out.println("旧数据:"+student.toString());
        student.setPhone("17317715623");
        studentService.save(student);
        Student student2 = studentService.getStudent(id);
        System.out.println("新数据:"+student2.toString());
        return student2.toString();
    }

    /**
     * 删除学生信息
     * @return
     */
    @RequestMapping(value = "/deleteInfo",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody String deleteInfo(){
        List<Student> studentList = studentService.getAllStudent();
        String id = studentList.get(studentList.size()-1).getId();
        System.out.println("id:"+id);
        studentService.deleteStudentInfoById(id);
        return "delete Success";
    }

    /**
     * 根据年龄范围获取到范围内学生信息列表(通过注解查询数据)
     * @return
     */
    @RequestMapping(value = "/queryStudentInfo",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody String queryStudentInfo(){
        List<Student> studentList = studentService.findStudentInfoByAgeBetween(20,40);
        return studentList.toString();
    }

    /**
     * MongoTemplate更新信息
     * @return
     */
    @RequestMapping(value = "/updateDemo",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody String updateDemo(){
        List<Student> studentList = studentService.getAllStudent();
        String id = studentList.get(studentList.size()-1).getId();
        Student student = studentService.getStudent(id);
        student.setPhone("17317715623");
        studentService.updateDemo(student);
        return "updateDemo Success!";
    }
}
