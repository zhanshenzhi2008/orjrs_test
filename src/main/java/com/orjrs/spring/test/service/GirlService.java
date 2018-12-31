package com.orjrs.spring.test.service;

import com.orjrs.spring.test.model.Girl;

/**
 * GirlService
 *
 * @author orjrs
 * @date 2018-12-31 12:22
 */
public interface GirlService {
    /**
     * 根据主键查询女孩信息
     *
     * @param id 主键
     * @return Girl
     */
    Girl queryGirl(Long id);
}
