package com.orjrs.spring.test.unit;

import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * MockitoTest
 *
 * @author orjrs
 * @date 2018-12-31 11:15
 */
// @RunWith(MockitoJUnitRunner.class) // 方式1: 可以自动触发所有的@Mock注解对象的创建
public class MockitoTest {
    @Rule  // 方式2: 可以自动触发所有的@Mock注解对象的创建
    public MockitoRule mockitoRule = MockitoJUnit.rule();

//    @Before // 方式3: @Test注解的方法运行前执行，触发所有的@Mock注解对象的创建
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }

}
