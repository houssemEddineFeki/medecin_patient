package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.dao.IMedecinDAO;
import com.example.demo.dao.MedecinDAO;
import com.example.demo.dao.MedecinRepository;
import com.example.demo.dao.PatientRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Medecin;
import com.example.demo.entities.MedecinGeneraliste;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {

	@Autowired
	private IMedecinDAO dao;
	@Autowired
	PatientRepository patRep;
	@Autowired
	MedecinRepository medRep;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder =new BCryptPasswordEncoder();
		return encoder ;
	}
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*List <Patient> l = patRep.findAll();
		for(int i=0; i<l.size();i++) {
			Patient m = l.get(i);
			System.out.println(m.getNom()+" "+m.getPrenom());
		}*/
		/*List <Medecin> lst =medRep.findAll();
		for(int i=0; i<lst.size();i++) {
			Medecin m = lst.get(i);
			System.out.println(m.getNom()+" "+m.getPrenom());
		}
		
		
		MedecinGeneraliste mg= new MedecinGeneraliste("Faouzi", "Njah", new Date(), "mohamed@gmail.com", null, "2222");
		medRep.save(mg);*/
		
		/*dao.addMedecin(new Medecin("Faouzi", "Njah", new Date(), "mohamed@gmail.com", null, "2222", null));
		Medecin m = dao.findMedecinByID(3L);
		m.setPrenom("Mariam");
		dao.updateMedecin(m);
		dao.deleteMedecin(2L);*/
		//insertion des rôles de l'application
		/*Role admin= new Role("ADMIN", "administrateur");
		Role patient= new Role("PATIENT", "patient");
		Role medecin= new Role("MEDECIN", "medecin");
		roleRepository.save(admin);
		roleRepository.save(patient);
		roleRepository.save(medecin);*/
		
		//insertion de 3 utilisateurs
		String password = passwordEncoder().encode("1111");
		User adminUser= new User("admin", password, true);
		Collection<Role> lst= new ArrayList<>();
		lst.add(roleRepository.findById("ADMIN").get());
		adminUser.setRoles(lst);
		//userRepository.save(adminUser);
		String password2 = passwordEncoder().encode("p2222");
		User pUser= new User("patient1", password2, true);
		Collection<Role> lst1= new ArrayList<>();
		lst1.add(roleRepository.findById("PATIENT").get());
		pUser.setRoles(lst1);
		//userRepository.save(pUser);
		String password3 = passwordEncoder().encode("m2222");
		User mUser= new User("medecin1", password3, true);
		Collection<Role> lst2= new ArrayList<>();
		lst2.add(roleRepository.findById("MEDECIN").get());
		mUser.setRoles(lst2);
		//userRepository.save(mUser);
	}
}
