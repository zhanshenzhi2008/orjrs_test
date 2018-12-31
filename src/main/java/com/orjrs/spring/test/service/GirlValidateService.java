package com.orjrs.spring.test.service;

/**
 * GirlValidateService
 *
 * @author orjrs
 * @date 2018-12-31 11:39
 */
public interface GirlValidateService {
    /**
     * 校验名字
     *
     * @param name 名字
     * @return true：通过，false：不通过
     */
    boolean validate(String name);
}
