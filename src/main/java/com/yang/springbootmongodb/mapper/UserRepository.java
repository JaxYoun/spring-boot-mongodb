package com.yang.springbootmongodb.mapper;

import com.yang.springbootmongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Yang
 * @date: 2019/7/7 18:02
 * @description:
 */
@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findOneByName(String name);

    @Override
    User insert(User user);
}
