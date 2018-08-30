package com.wangxin.mongodb.demo.mongodbdemo.service.impl;

import com.wangxin.mongodb.demo.mongodbdemo.domain.Student;
import com.wangxin.mongodb.demo.mongodbdemo.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:jzwx
 * @Desicription: StudentService
 * @Date:Created in 2018-08-30 10:06
 * @Modified By:
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(String id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public void deleteStudentInfoById(String id){
        studentRepository.deleteById(id);
    }

    public List<Student> findStudentInfoByAgeBetween(Integer ageGT, Integer ageLT){
        return studentRepository.findStudentInfoByAgeBetween(ageGT,ageLT);
    }

    public void updateDemo(Student student){
        Query query = new Query(Criteria.where("id").is(student.getId()));
        Update update = new Update();
        update.set("sName",student.getsName());
        update.set("sex",student.getSex());
        update.set("age",student.getAge());
        update.set("phone",student.getPhone());
        update.set("photo",student.getPhoto());
        mongoTemplate.updateFirst(query,update,Student.class);
    }
}
