package com.ua.sutty.crud.service;

import com.ua.sutty.crud.model.User;
import com.ua.sutty.crud.repository.UsersRepository;
import com.ua.sutty.crud.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        Optional<User> userCandidate = usersRepository.findOneByLogin(login);
//        if (userCandidate.isPresent()){
//            return new UserDetailsImpl(userCandidate.get());
//        }else {
//            throw new IllegalArgumentException("User not found");
//        }
        return new
                UserDetailsImpl(usersRepository.findOneByLogin(login).
                orElseThrow(IllegalArgumentException::new));
    }
}
