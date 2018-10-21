package com.ua.sutty.crud.controller;

import com.ua.sutty.crud.form.UserForm;
import com.ua.sutty.crud.model.User;
import com.ua.sutty.crud.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    public String getUsersPage(ModelMap model) {
        model.addAttribute("usersFromServer", usersRepository.findAll());
        return "users";
    }

    @PostMapping("/users")
    public String addUser(UserForm userForm){
        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .build();
        System.out.println(user);
        usersRepository.save(user);
        return "redirect:users";
    }

}
