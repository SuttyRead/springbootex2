package com.ua.sutty.crud.repository;

import com.ua.sutty.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 18.04.2018
 * UsersRepository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Transactional
public interface UsersRepository extends JpaRepository<User, Long> {
    User getUserById(Long id);

//    @Query("update user u set u.first_name = (:first_name), u.last_name = (:last_name) where u.id = (:userId)")
//    void updateUser(@Param("first_name")String first_name,@Param("last_name") String last_name,@Param("userId") Long userId);

}
