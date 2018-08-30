package com.wangxin.mongodb.demo.mongodbdemo.service;

import com.wangxin.mongodb.demo.mongodbdemo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @Author:jzwx
 * @Desicription: StudentRepository
 * @Date:Created in 2018-08-30 10:06
 * @Modified By:
 */
public interface StudentRepository extends MongoRepository<Student, String>{
    @Query("{'age':{$gt:?0,$lt:?1}}")
    List<Student> findStudentInfoByAgeBetween(Integer ageGT, Integer ageLT);
}
