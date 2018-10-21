package com.ua.sutty.crud.repository;

import com.ua.sutty.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 18.04.2018
 * UsersRepository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersRepository extends JpaRepository<User, Long> {

}
