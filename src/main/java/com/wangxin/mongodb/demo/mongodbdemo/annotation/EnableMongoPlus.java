package com.wangxin.mongodb.demo.mongodbdemo.annotation;

import com.wangxin.mongodb.demo.mongodbdemo.config.MongoPlusAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;
/**
 * @Author:jzwx
 * @Desicription: EnableMongoPlus
 * @Date:Created in 2018-08-29 15:54
 * @Modified By:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({MongoPlusAutoConfiguration.class})
public @interface EnableMongoPlus {
}
