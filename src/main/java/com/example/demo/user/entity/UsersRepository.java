package com.example.demo.user.entity;

import com.example.demo.auth.entity.AuthEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends CrudRepository<UsersEntity, String> {
    @Query("select count(users.id) from users  join auth  on users.id = auth.id and users.id = :#{#Users.id} and auth.api_key = :#{#Auth.apiKey}")
    public int findByIdAndApiKey(@Param("Users") UsersEntity usersEntity, @Param("Auth")AuthEntity authEntity);
}
