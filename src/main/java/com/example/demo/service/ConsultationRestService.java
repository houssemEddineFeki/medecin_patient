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

import com.example.demo.dao.ConsultationRepository;
import com.example.demo.dao.MedecinRepository;
import com.example.demo.entities.Consultation;
import com.example.demo.entities.Medecin;

@RestController
public class ConsultationRestService {
	@Autowired
	ConsultationRepository cRep;
	
	@RequestMapping(value = "/consultations", method = RequestMethod.GET)
	public List<Consultation> findMedecins() {
		return cRep.findAll();
	}
	
	@RequestMapping(value="/consultations/{id}", method=RequestMethod.GET)
	public Consultation findOneConsultation(@PathVariable Long id)
	{
		return cRep.findById(id).get();
	}
	
	@PostMapping(value="/consultations")
	public Consultation saveConsultation(@RequestBody Consultation c)
	{
		return cRep.save(c);
	}
	
	@RequestMapping(value="/consultations/{id}", method=RequestMethod.DELETE)
	public void deleteConsultation(@PathVariable Long id)
	{
		cRep.deleteById(id);
	}
	@RequestMapping(value="/consultations/{id}", method=RequestMethod.PUT)
	public Consultation updateConsultation(@PathVariable(name="id") Long id,@RequestBody Consultation c)
	{
		c.setId(id);
		return cRep.save(c);
	}
	
}
