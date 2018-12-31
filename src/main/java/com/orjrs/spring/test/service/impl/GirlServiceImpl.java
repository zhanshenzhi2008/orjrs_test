package com.orjrs.spring.test.service.impl;

import com.orjrs.spring.test.model.Girl;
import com.orjrs.spring.test.service.GirlService;
import org.springframework.stereotype.Service;

/**
 * GirlServiceImpl
 *
 * @author orjrs
 * @date 2018-12-31 12:25
 */
@Service("girlService")
public class GirlServiceImpl implements GirlService {
    @Override
    public Girl queryGirl(Long id) {
        Girl girl = new Girl();
        girl.setId(1L);
        girl.setName("张女士");
        girl.setAge(23);
        if (id.equals(girl.getId())) {
            return girl;
        }
        return null;
    }
}
