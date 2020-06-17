package com.yang.springbootmongodb.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author: Yang
 * @date: 2019/7/7 17:59
 * @description:
 */
@Data
@Builder
@Document(collection = "c_user")
public class User {

    @Id
    private Long id;

    @Field("name")
    private String name;

    @Field("age")
    private Integer age;

    @Field("address")
    private String address;

    @Field("title")
    private String title;

}
