package com.provApp.gestionApp.controlleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.models.Alert;
import com.provApp.gestionApp.persistence.DataRepository;
import com.provApp.gestionApp.persistence.PersonnelRepository;

import lombok.NoArgsConstructor;

@Component @Scope("prototype") @NoArgsConstructor
public class SupprimerInformation {

	PersonnelRepository repo ;
	DataRepository repoData ;


	@Autowired
	public SupprimerInformation( PersonnelRepository rep, DataRepository repData ) {
		super();
		this.repo = rep ;
		this.repoData = repData ;
	}
	public void suppInformation(int numOrd) {
		if (repoData.existsById(numOrd)) {
			repoData.deleteById(numOrd);
			new Alert("Supprimé avec succés.") ;
	}else {
			new Alert("Aucune données trouvé.") ;
		}
	}
	
	public void suppPersonnel(int identifiant) {
		if (repo.existsById(identifiant)) {
			repo.deleteById(identifiant);
			new Alert("Supprimé avec succés.") ;
	}else {
			new Alert("account doesn't exist.") ;
		}
	}
}
