package com.provApp.gestionApp.controlleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.entities.DataEntity;
import com.provApp.gestionApp.entities.PersonnelEntity;
import com.provApp.gestionApp.models.Alert;
import com.provApp.gestionApp.persistence.DataRepository;
import com.provApp.gestionApp.persistence.PersonnelRepository;

import lombok.NoArgsConstructor;

@Component @NoArgsConstructor
public class AjouterInforamtion {

	PersonnelRepository repo ;
	DataRepository repoData ;
	
	@Autowired
	public AjouterInforamtion( PersonnelRepository rep, DataRepository repData ) {
		super();
		this.repo = rep ;
		this.repoData = repData ;
	}

	public void ajouterDonnees(DataEntity dataEntity) {
		if (dataEntity.getId() != null) {
			int result = repoData.addEntity(dataEntity) ;
			if (result != 0) {
				new Alert("Succés") ;
			} else {
				new Alert("problème dans l'exécution") ;

			}
		}else {
		DataEntity res = repoData.save(dataEntity) ;
		if (res != null) {
			new Alert("Succés") ;
		} else {
			new Alert("problème dans l'exécution") ;

		}
		}
		
	}

	public void ajouterPersonnel(PersonnelEntity perso ) {
		
		if (perso.getId() != null) {
			int result = repo.addEntity(perso) ;
			if (result != 0) {
				new Alert("Succés") ;
			} else {
				new Alert("problème dans l'exécution") ;

			}
		}else {
		PersonnelEntity res = repo.save(perso) ;
		if (res != null) {
			new Alert("Succés") ;
		} else {
			new Alert("problème dans l'exécution") ;
			   }
		}
	}
}
