package com.ua.sutty.crud.controller;

import com.ua.sutty.crud.security.details.UserDetailsImpl;
import com.ua.sutty.crud.transfer.UserDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import static com.ua.sutty.crud.transfer.UserDTO.from;

@Controller
public class ProfileController {

    @GetMapping("/")
    public String getProfilePage(ModelMap modelMap, Authentication authentication){

        if (authentication == null){
            return "redirect:/login";
        }

        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
        UserDTO userDTO = from(userDetails.getUser());

        modelMap.addAttribute("user", userDTO);
        return "profile";
    }

}
