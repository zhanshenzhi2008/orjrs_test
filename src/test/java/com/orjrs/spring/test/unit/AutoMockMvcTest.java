package com.orjrs.spring.test.unit;

import com.orjrs.spring.test.TestApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * MockMvcTest
 *
 * @author orjrs
 * @date 2018-10-21 16:12
 */
@WebAppConfiguration // 1
@AutoConfigureMockMvc // 开启MockMvc自动注解
public class AutoMockMvcTest extends TestApplicationTests {
    // @Autowired
    // private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    /*@Before // @Test注解的方法运行前执行，MockMvcBuilder构造MockMvc实例
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }*/

    @Test
    public void post() throws Exception {
        String name = "Smart LIU";
        String msg = "您好";
        mockMvc.perform(
                MockMvcRequestBuilders.post("/unit/sayHello/" + name + "/" + msg)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                //.content()
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
