package com.perscholas.PersonalExpenses.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.perscholas.PersonalExpenses.entity.User;
import com.perscholas.PersonalExpenses.repository.UserRegistrationDto;
import com.perscholas.PersonalExpenses.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	Logger log = LoggerFactory.getLogger(UserRegistrationController.class);

	 @Autowired
	   private UserService userService;

	   @ModelAttribute("user")
	   public UserRegistrationDto userRegistrationDto() {
	       return new UserRegistrationDto();
	   }

	   @GetMapping
	   public String showRegistrationForm(Model model) {
		   log.info("showRegistrationForm is called from controller");
	       return "registration";
	   }

	   @PostMapping
	   public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result){

	       User existing = userService.findByEmail(userDto.getEmail());
	       if (existing != null){
	           result.rejectValue("email", null, "There is already an account registered with that email");
	       }

	       if (result.hasErrors()){
	           return "registration";
	       }

	       userService.save(userDto);
	       return "redirect:/registration?success";
	   }
}
