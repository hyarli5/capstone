package com.perscholas.PersonalExpenses.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserLoginController {
	Logger log = LoggerFactory.getLogger(UserLoginController.class);

	@GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
    	log.info("userIndex is called from controller");
        return "user/index";
    }
}
