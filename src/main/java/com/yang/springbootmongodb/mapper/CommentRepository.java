package com.yang.springbootmongodb.mapper;

import com.yang.springbootmongodb.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Yang
 * @date: 2020/6/18 00:22
 * @description:
 */
@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findAllByNickname(String nickName);

    Comment findOneByNickname(String nickName);

    void deleteByArticleidEqualsAndReplynumLessThan(String articalId, Integer replynum);

    Page<Comment> findByParentid(String parentId, Pageable pageable);

}
