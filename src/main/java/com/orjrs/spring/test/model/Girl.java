package com.orjrs.spring.test.model;

import lombok.Data;

/**
 * Girl
 *
 * @author orjrs
 * @date 2018-12-31 12:23
 */
@Data
public class Girl {
    /** 流水号 */
    private Long id;

    /** 名字 */
    private String name;

    /** 年龄 */
    private int age;
}
