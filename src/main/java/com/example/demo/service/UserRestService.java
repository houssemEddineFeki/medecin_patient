package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;

@RestController
public class UserRestService {
	@Autowired
	UserRepository userRepository;
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public User save(User u)
	
	{
		return userRepository.save(u);
	}
	@RequestMapping(value="/listUser", method=RequestMethod.GET)
	public List<User> listAll()
	{
		return userRepository.findAll();
	}
	
	

}
