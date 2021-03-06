package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;

@RestController
public class UserRestService {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/users/add", method=RequestMethod.POST)
	public User save(@RequestBody User u)
	{
		return userRepository.save(u);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> listAll()
	{
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/users/{username}", method=RequestMethod.GET)
	public User findOneUser(@PathVariable String username)
	{
		return userRepository.findById(username).get();
	}
	
	@RequestMapping(value="/users/UserRole/{username}", method=RequestMethod.GET)
	public Collection<Role> findUserRole(@PathVariable String username)
	{
		return userRepository.findById(username).get().getRoles();
	}
	
	@RequestMapping(value="/users/delete/{user}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable String user)
	{
		userRepository.deleteById(user);
	}
	
	@RequestMapping(value="/users/update/{username}", method=RequestMethod.PUT)
	public User updateUser(@PathVariable(name="username") String username,@RequestBody User u)
	{
		u.setUsername(username);
		return userRepository.save(u);
	}
	
	
	
	

}
