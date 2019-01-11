package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Consultation;
import com.example.demo.entities.Medecin;

public interface ConsultationRepository extends JpaRepository<Consultation, Long>{

}
