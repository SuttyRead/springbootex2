package com.ua.sutty.crud.controller;

import com.ua.sutty.crud.form.UserForm;
import com.ua.sutty.crud.model.User;
import com.ua.sutty.crud.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;

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
    public String addUser(UserForm userForm) {
        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .build();
        System.out.println(user);
        usersRepository.save(user);
        return "redirect:users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        usersRepository.delete(id);
        return "redirect:/users";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id")Long id, UserForm userForm) {
        User user = usersRepository.getUserById(id);
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        System.out.println(user);
        System.out.println("Hello");
        usersRepository.saveAndFlush(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = usersRepository.getUserById(id);
        model.addAttribute("userEdit", user);
        System.out.println(user);
        return "edit";
    }

}
