package com.wangxin.mongodb.demo.mongodbdemo.service;


import com.wangxin.mongodb.demo.mongodbdemo.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 客户数据访问服务
 *
 * @author XiongNeng
 * @version 1.0
 * @since 2018/3/3
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

}
