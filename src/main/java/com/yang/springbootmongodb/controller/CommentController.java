package com.yang.springbootmongodb.controller;

import com.yang.springbootmongodb.entity.Comment;
import com.yang.springbootmongodb.entity.Location;
import com.yang.springbootmongodb.entity.User;
import com.yang.springbootmongodb.mapper.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Yang
 * @date: 2020/6/18 00:24
 * @description:
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private CommentRepository commentRepository;

    @GetMapping("/add")
    public void add() {
        List<Location> locationList = new ArrayList() {{
            add(Location.builder().name("中国").shortname("cn").x(100).y(200).build());
            add(Location.builder().name("美国").shortname("us").x(111).y(222).build());
        }};

        User user = User.builder().address("中国-四川-成都").name("杨").build();

        Comment comment = Comment.builder()
                .state("1")
                .replynum(19)
                .likenum(100)
                .parentid("12")
                .articleid("0001")
                .nickname("山葵酱")
                .content("垃圾营销号")
                .publishtime(new Date())
                .createdatetime(LocalDateTime.now())
                .locationList(locationList)
                .user(user)
                .build();
        this.commentRepository.insert(comment);
    }


    @GetMapping("/listAll")
    public List<Comment> listAll() {
        return this.commentRepository.findAll();
    }

    @GetMapping("/list")
    public Comment list() {
        return this.commentRepository.findOneByNickname("山葵酱");
    }

    @GetMapping("/delete")
    public void delete() {
        this.commentRepository.deleteByArticleidEqualsAndReplynumLessThan("0002", 20);
    }

    @GetMapping("/page")
    public Page<Comment> page() {
        return this.commentRepository.findByParentid("12", PageRequest.of(0, 4));
    }

    /**
     * 局部更新
     */
    @GetMapping("/update")
    public void update() {
        Query query = Query.query(Criteria.where("nickname").is("山葵酱"));
        Update update = new Update();
        update.inc("likenum");
        this.mongoTemplate.updateMulti(query, update, Comment.class);
    }


}
