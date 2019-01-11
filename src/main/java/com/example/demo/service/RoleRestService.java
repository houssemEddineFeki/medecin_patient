package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Medecin;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;

@RestController
public class RoleRestService {
	@Autowired
	RoleRepository roleRepository;
	
	@RequestMapping(value="/roles/add", method=RequestMethod.POST)
	public Role save(@RequestBody Role r)
	{
		return roleRepository.save(r);
	}
	
	@RequestMapping(value="/roles", method=RequestMethod.GET)
	public List<Role> listAll()
	{
		return roleRepository.findAll();
	}
	
	@RequestMapping(value="/roles/{role}", method=RequestMethod.GET)
	public Role findOneRole(@PathVariable String role)
	{
		return roleRepository.findById(role).get();
	}
	
	@RequestMapping(value="/roles/delete/{role}", method=RequestMethod.DELETE)
	public void deleteRole(@PathVariable String role)
	{
		roleRepository.deleteById(role);
	}
	
	@RequestMapping(value="/roles/update/{role}", method=RequestMethod.PUT)
	public Role updateRole(@PathVariable(name="role") String role,@RequestBody Role r)
	{
		r.setRole(role);
		return roleRepository.save(r);
	}
}
