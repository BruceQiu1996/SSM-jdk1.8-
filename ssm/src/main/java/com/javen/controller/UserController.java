package com.javen.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.model.User;
import com.javen.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger log=LoggerFactory.getLogger(UserController.class);
	@Resource  
    private IUserService userService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)  
    public @ResponseBody User getUserInJson(@PathVariable String id){  
        int userId = Integer.parseInt(id);  
        System.out.println("userId:"+userId);
        User user = this.userService.getUserById(userId);  
        log.info(user.toString());
        return user;  
    } 
	@RequestMapping(value="/all",method=RequestMethod.GET)  
    public @ResponseBody List<User> getUsersInJson(){  
        List<User> users = this.userService.getAllUser();
        return users;  
    }  
}
