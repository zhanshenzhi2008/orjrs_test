package com.orjrs.spring.test.unit;

import com.orjrs.spring.test.TestApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBootTestDemo
 *
 * @author orjrs
 * @date 2018-10-06 19:51
 */
@RunWith(SpringRunner.class)
//@SpringBootTest // 1
@SpringBootTest(classes = TestApplication.class) // 2
//@SpringBootTest(classes={TestApplication.class,XXX.class}) // 3
public class SpringBootTestDemo {
    // 1. 测试类会自动加载启动类，默认module下的启动类
    // 2. 可以指定具体的启动类，且可以多个(3)
    // 4. SpringBoot 2.0+版本后，默认生产启动测试类，
    //    可以直接extends TestApplicationTests，这样就不用家@RunWith和@SpringBo0tTest注解
}
