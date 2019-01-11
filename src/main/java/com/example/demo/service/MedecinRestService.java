package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MedecinRepository;
import com.example.demo.entities.Medecin;
import com.example.demo.entities.Patient;

@RestController
public class MedecinRestService {
	@Autowired
	MedecinRepository mRep;
	
	@RequestMapping(value = "/medecins", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public List<Medecin> findMedecins() {
		return mRep.findAll();
	}
	
	@RequestMapping(value="/medecins/{id}", method=RequestMethod.GET)
	public Medecin findOneMedecin(@PathVariable Long id)
	{
		return mRep.findById(id).get();
	}
	
	@PostMapping(value="/medecins/add")
	public Medecin saveMedecin(@RequestBody Medecin m)
	{
		return mRep.save(m);
	}
	
	@RequestMapping(value="/medecins/delete/{id}", method=RequestMethod.DELETE)
	public void deleteMedecin(@PathVariable Long id)
	{
		mRep.deleteById(id);
	}
	@RequestMapping(value="/medecins/update/{id}", method=RequestMethod.PUT)
	public Medecin updateMedecin(@PathVariable(name="id") Long id,@RequestBody Medecin m)
	{
		m.setId(id);
		return mRep.save(m);
	}
}
