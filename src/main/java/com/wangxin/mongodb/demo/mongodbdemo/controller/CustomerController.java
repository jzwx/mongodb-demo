package com.wangxin.mongodb.demo.mongodbdemo.controller;

import com.wangxin.mongodb.demo.mongodbdemo.domain.Customer;
import com.wangxin.mongodb.demo.mongodbdemo.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:jzwx
 * @Desicription: CustomerController
 * @Date:Created in 2018-08-14 17:13
 * @Modified By:
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/getCustomerInfo", method = RequestMethod.GET)
    public @ResponseBody
    String getCustomerInfo() {
        // save a couple of customers
//        customerService.save(new Customer("Alice", "Smith"));
//        customerService.save(new Customer("Bob", "Smith"));
        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        int count = 0;
        for (Customer customer : customerService.findAll()) {
            System.out.println(customer);
            count++;
        }
        Customer c = customerService.findByFirstName("Alice");
        System.out.println("System.out.println(c.toString()):" + c.toString());

        List<Customer> list = customerService.findByLastName("Smith");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list[" + i + "]:" + list.get(i).toString());
        }
        return "ok";
    }
}
