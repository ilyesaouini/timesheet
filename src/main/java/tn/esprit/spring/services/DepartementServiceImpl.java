package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;


@Service
public class DepartementServiceImpl implements IDepartementService {

	
	@Autowired
	DepartementRepository departementRepository;
	
	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);

	@Override
	public List<Departement> retrieveAllDepartements() { 
		List<Departement> departements = null; 
		try {
	
			l.info("In method retrieveAllUsers :"); 
			departements = (List<Departement>) departementRepository.findAll();  
			l.debug("connexion à la DB Ok:");
			
			for (Departement departement : departements) {
				l.debug("departement :" + departement.getName());   
			} 
			l.info("Out of method retrieveAllDepartements with success");
		}catch (Exception e) {
			l.error("Out of method retrieveAllDepartements with Error :"+ e);
		}

		return departements;
	}


	@Override
	public Departement addDepartement(Departement d) {
		l.info("In of Methode departement:"); 
		Departement d_saved = departementRepository.save(d); 
		l.info("Out of Methode adddepartement:");
		return d_saved; 
	}

	@Override 
	public Departement updateDepartement(Departement d) { 
		l.info("In of Methode updateDepartement:"); 
		Departement d_saved = departementRepository.save(d); 
		l.info("Out of Methode updatedepartement:"); 
		return d_saved; 
	}

	@Override
	public void deleteDepartement(String id) {
		l.info("In of Methode deletedepartement:"); 
		departementRepository.deleteById(Long.parseLong(id)); 
		l.info("Out of Methode deletedepartement:"); 
	}

	@Override
	public Departement retrieveDepartement(String id) {
		l.info("In of Methode retrieveDepartement:"); 
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		Departement d =  departementRepository.findById(Long.parseLong(id)).get(); 

		return d; 
	}


}
