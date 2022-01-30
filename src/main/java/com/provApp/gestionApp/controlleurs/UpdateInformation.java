package com.provApp.gestionApp.controlleurs;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.models.Alert;
import com.provApp.gestionApp.persistence.DataRepository;
import com.provApp.gestionApp.persistence.PersonnelRepository;

import lombok.NoArgsConstructor;

@Component @NoArgsConstructor
public class UpdateInformation {

	DataRepository dataRepo ;
	PersonnelRepository persoRepo ;
		
	@Autowired
	public UpdateInformation(DataRepository dataRep, PersonnelRepository persoRep) {
		super();
		this.dataRepo = dataRep ;
		this.persoRepo = persoRep ;
		}
	
	public void updtInformation(int ordAnn,int newOrdAnn ,Date dateArr, String desig, String analyse, String division) {
		int res = dataRepo.updateByAllSpecification(ordAnn, newOrdAnn, dateArr, desig, analyse, division) ;
		if (res != 0 ) {
			new Alert("Changé avec succés") ;
			
		}else {
			new Alert("Erreur") ;
		}
	}

	public void updtPersonnel(int identifiant,int newIdentifiant, String userName, String password, String type) {
		int res = persoRepo.updateByAllSpecification(identifiant, newIdentifiant, userName, password, type);
		if (res != 0 ) {
			new Alert("Changé avec succés") ;
			
		}else {
			new Alert("Erreur") ;
		}
	}

}
