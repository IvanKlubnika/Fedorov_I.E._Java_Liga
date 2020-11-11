package com.homework.social.repository;


import com.homework.social.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SocialRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    //Запрос заносит друга в базу данных
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO friends (id_user, id_friend) VALUES (:user_id, :friend_id)", nativeQuery = true)
    Integer addFriend(@Param("user_id")   long userId,
                      @Param("friend_id") long friendId
    );

    //Запрос удаляет друга из базы данных
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM friends WHERE (id_user = :user_id) AND (id_friend = :friend_id)", nativeQuery = true)
    Integer deleteFriend(@Param("user_id")Long userId,
                         @Param("friend_id") Long friendId
    );


    @Modifying
    @Transactional
    @Query(value = "SELECT id_friend FROM friends WHERE id_user = :ids", nativeQuery = true)
    List<Long> showFriends(@Param("ids") Long userId);

}
