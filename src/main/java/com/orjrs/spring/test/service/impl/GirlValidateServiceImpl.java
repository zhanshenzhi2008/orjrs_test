package com.orjrs.spring.test.service.impl;

import com.orjrs.spring.test.model.Girl;
import com.orjrs.spring.test.service.GirlService;
import com.orjrs.spring.test.service.GirlValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * GirlValidateServiceImpl
 *
 * @author orjrs
 * @date 2018-12-31 11:40
 */
@Service("girlValidateService")
public class GirlValidateServiceImpl implements GirlValidateService {
    private final GirlService girlService;

    @Autowired
    public GirlValidateServiceImpl(GirlService girlService) {
        this.girlService = girlService;
    }

    @Override
    public boolean validate(String name) {
        if (StringUtils.isEmpty(name)) {
            return false;
        }
        Girl girl = girlService.queryGirl(1L);
        if (girl != null && name.equals(girl.getName())) {
            return true;
        }
        return false;
    }
}
