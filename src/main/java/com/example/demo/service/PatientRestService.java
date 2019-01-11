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

import com.example.demo.dao.PatientRepository;
import com.example.demo.entities.Medecin;
import com.example.demo.entities.Patient;

@RestController
public class PatientRestService {
	@Autowired
	PatientRepository pRep;

	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	@Secured({"ROLE_ADMIN", "ROLE_MEDECIN"})
	public List<Patient> findPatients() {
		return pRep.findAll();
	}
	
	@RequestMapping(value="/patients/{id}", method=RequestMethod.GET)
	public Patient findOnePatient(@PathVariable Long id)
	{
		return pRep.findById(id).get();
	}
	
	@RequestMapping(value="/patients/MG/{id}", method=RequestMethod.GET)
	public Medecin findMG(@PathVariable Long id)
	{
		Patient p=pRep.findById(id).get();
		return p.getGeneraliste();
	}
	
	@PostMapping(value="/Patients/add")
    public Patient savePatient(@RequestBody Patient p)
	{
		return pRep.save(p);
	}
	
	@RequestMapping(value="/patients/update/{id}", method=RequestMethod.DELETE)
	public void deletePatient(@PathVariable Long id)
	{
		pRep.deleteById(id);
	}
	
	@RequestMapping(value="/patients/{id}", method=RequestMethod.PUT)
	public Patient updateContact(@PathVariable(name="id") Long id,@RequestBody Patient p)
	{
		p.setId(id);
		return pRep.save(p);
	}
}
