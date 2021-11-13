package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {

	   List<Contrat> retrieveAllContrats();
		Contrat addContract(Contrat c);
		void deleteContrat(String id);
	    Contrat updateContrat(Contrat c);
	    Contrat retrieveContrat(String id);

}

