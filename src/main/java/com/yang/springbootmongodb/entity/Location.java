package com.yang.springbootmongodb.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author: Yang
 * @date: 2020/6/19 09:01
 * @description: 位置
 */
@Data
@Builder
public class Location {

    /**
     * 全名
     */
    private String name;

    /**
     * 简称
     */
    private String shortname;

    /**
     * 经度
     */
    private int x;

    /**
     * 纬度
     */
    private int y;

}
