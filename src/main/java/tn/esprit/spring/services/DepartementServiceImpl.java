package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.User;
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
				// TODO Log à ajouter pour affiher chaque user dans les logs   
			} 
			l.info("Out of method retrieveAllUsers with success");
		}catch (Exception e) {
			l.error("Out of method retrieveAllUsers with Error :"+ e);
		}

		return departements;
	}


	@Override
	public Departement addDepartement(Departement d) {
		// TODO Log à ajouter en début de la méthode 
		Departement d_saved = departementRepository.save(d); 
		// TODO Log à ajouter à la fin de la méthode 
		return d_saved; 
	}

	@Override 
	public Departement updateDepartement(Departement d) { 
		// TODO Log à ajouter en début de la méthode 
		Departement d_saved = departementRepository.save(d); 
		// TODO Log à ajouter à la fin de la méthode 
		return d_saved; 
	}

	@Override
	public void deleteDepartement(String id) {
		// TODO Log à ajouter en début de la méthode 
		departementRepository.deleteById(Long.parseLong(id)); 
		// TODO Log à ajouter à la fin de la méthode 
	}

	@Override
	public Departement retrieveDepartement(String id) {
		// TODO Log à ajouter en début de la méthode 
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		Departement d =  departementRepository.findById(Long.parseLong(id)).get(); 
		// TODO Log à ajouter à la fin de la méthode 
		return d; 
	}


}
