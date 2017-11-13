package com.springboot.persistence;

import com.springboot.model.User;
import com.springboot.model.UserConst;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import java.util.Optional;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Component
public class UserDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Optional<User> findByUserName(@NonNull String username) {
        return Optional.ofNullable(
                mongoTemplate.findOne(
                        query(
                                where(UserConst.USER_NAME.getName()).is(username)),
                        User.class));
    }

    public void save(@NonNull User user) {
        mongoTemplate.save(user);
    }
}