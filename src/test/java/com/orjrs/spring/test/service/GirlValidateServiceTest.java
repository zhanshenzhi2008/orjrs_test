package com.orjrs.spring.test.service;

import com.orjrs.spring.test.model.Girl;
import com.orjrs.spring.test.service.impl.GirlValidateServiceImpl;
import com.orjrs.spring.test.unit.MockitoTest;
import org.junit.Test;
import org.mockito.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * GirlValidateServiceTest
 *
 * @author orjrs
 * @date 2018-12-31 12:20
 */
public class GirlValidateServiceTest extends MockitoTest {
    @Mock
    private GirlService girlService;

    @Spy
    private GirlService spyGirlService;

    @InjectMocks // 创建一个实例,并注入@Mock的实例,注意这些@mock的实例必须是当前实例的Construct注入、setter注入、property注入
    private GirlValidateServiceImpl girlValidateServiceImpl;

    @Test
    public void validate() {
        // 创建实例，mock对象作为构造函数的参数
        GirlValidateService girlValidateService = new GirlValidateServiceImpl(girlService);
        // 可以直接调用imGirlValidateServiceg，不需要上面的初始化
        // imGirlValidateServiceg.validate("张女士");

        // 1.mock 创建测试
        boolean flag = girlValidateService.validate("张女士");
        assertFalse(flag);
        // 该方法体内调用GirlService的方法，此时@Mock出来的虚拟对象，是不会调用其实际方法girlService.queryGirl，
        // 所以返回的是null，导致判断为false
        Mockito.verify(girlService).queryGirl(1L); // 验证queryGirl调用是通过Mock对象的，这个方法的结果为null

        // 2. 配置mocks的测试：如果调用这个方法，始终返回一个自定义的对象
        Mockito.when(girlService.queryGirl(1L)).thenReturn(new Girl() {{
            setId(0L);
            setName("李女士");
        }}); // girlService.queryGirl实际方法我已经写死了:1L 张女士 23
        assertTrue(girlValidateService.validate("李女士")); // // 验证校验方法

        // 创建实例，mock对象作为构造函数的参数
        GirlValidateService spyGirlValidateService = new GirlValidateServiceImpl(spyGirlService);
        Mockito.when(spyGirlService.queryGirl(1L)).thenReturn(new Girl() {{
            setId(0L);
            setName("李女士");
        }}); // girlService.queryGirl实际方法我已经写死了:1L 张女士 23
        // assertFalse(spyGirlValidateService.validate("李女士")); // spy模拟的对象，会调用实际方法，故这个结果不相同
        Mockito.doReturn(new Girl() {{
            setId(0L);
            setName("李女士");
        }}).when(spyGirlService).queryGirl(1L);  // girlService.queryGirl实际方法我已经写死了:1L 张女士 23
        assertTrue(spyGirlValidateService.validate("李女士")); // spy模拟的对象，会调用实际方法，故这个结果不相同
    }

    @Test
    public void testLinkedListSpyWrong() {
        // mock 一个LinkedList
        List<Girl> list = new LinkedList<>();
        List<Girl> spy = Mockito.spy(list);

        // 这个方法不会执行，因为spy的对象会去执行其实际方法，即spy.get(0)会去调用实际的方法，而list目前一个empty，则get(0)会异常
        Mockito.when(spy.get(0)).thenReturn(new Girl() {{
            setId(0L);
            setName("李女士");
        }});
        // 上面一句会报错，这里不会执行
        assertEquals("李女士", spy.get(0).getName());
    }

    @Test
    public void testLinkedListSpyCorrect() {
        // mock 一个LinkedList
        List<Girl> list = new LinkedList<>();
        List<Girl> spy = Mockito.spy(list);

        // 这个方法不会执行，因为spy的对象会去执行其实际方法，即spy.get(0)会去调用实际的方法，而list目前一个empty，则get(0)会异常
        // 但doReturn when方法和when thenReturn不一样，.when(spy)并不会报错，调用get(0)它始终会返回一个结果
        Mockito.doReturn(new Girl() {{
            setId(0L);
            setName("李女士");
        }}).when(spy).get(0); // .when(spy).get(0);如果改成 when(spy.get(0))，一样会报错
        // 会执行这行代码
        assertEquals("李女士", spy.get(0).getName());
    }

    @Test
    public void testVerify() {
        // create and configure mock
        Girl girl = Mockito.mock(Girl.class);
        Mockito.when(girl.getId()).thenReturn(3L);

        // call method setName on the mock with parameter 张三
        girl.setName("张三");
        girl.getId();
        girl.getId();


        // now check if method testing was called with the parameter 张三
        Mockito.verify(girl).setName(ArgumentMatchers.eq("张三"));

        // was the method called twice?
        Mockito.verify(girl, Mockito.times(2)).getId();

        // other alternatives for verifiying the number of method calls for a method
        Mockito.verify(girl, Mockito.never()).setName("never called");
        Mockito.verify(girl, Mockito.atLeastOnce()).setName("called at least once");
        Mockito.verify(girl, Mockito.atLeast(2)).setName("called at least twice");
        Mockito.verify(girl, Mockito.times(5)).setName("called five times");
        Mockito.verify(girl, Mockito.atMost(3)).setName("called at most 3 times");
        // This let's you check that no other methods where called on this object.
        // You call it after you have verified the expected method calls.
        Mockito.verifyNoMoreInteractions(girl);
    }

}