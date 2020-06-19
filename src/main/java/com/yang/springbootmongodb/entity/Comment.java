package com.yang.springbootmongodb.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author: Yang
 * @date: 2020/6/18 00:01
 * @description:
 */
@Data
@Builder
// 1.若mongodb中的集合名称与实体类名的全小写相同，此处可以不显式声明集合名称。
@Document(collection = "c_comment")
// 2.声明复合索引，1：升序，-1：降序。
@CompoundIndex(def = "{'userid':1, 'articleid': -1}")
public class Comment implements Serializable {

    /**
     * 主键
     */
    @Id  //3.属性名为“id”时，此注解可以省略。
    private String id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 发表时间
     */
    private Date publishtime;

    /**
     * 用户主键
     */
    @Indexed()
    private String userid;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 创建时间
     */
    private LocalDateTime createdatetime;

    /**
     * 点赞数
     */
    private Integer likenum;

    /**
     * 回复数
     */
    private Integer replynum;

    /**
     * 状态
     */
    private String state;

    /**
     * 父id
     */
    private String parentid;

    /**
     * 文章id
     */
    private String articleid;

    /**
     *
     */
    private List<Location> locationList;

    private User user;


}
