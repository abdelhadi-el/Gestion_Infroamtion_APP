package com.provApp.gestionApp.controlleurs;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.entities.DataEntity;
import com.provApp.gestionApp.persistence.DataRepository;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component @NoArgsConstructor @Scope("prototype") @Data
public class ChercherInformation {   

	DataRepository repo ;
	
	@Autowired
	public ChercherInformation( DataRepository rep ) {
		super();
		this.repo = rep ;
	}
	
	public Optional<DataEntity> faireLaRecherche( int numOrdAnnuel ) {   // pour une information specifique
		if (numOrdAnnuel == -1) {
			return null ;
		}else {
			Optional<DataEntity> res = repo.findById(numOrdAnnuel) ;
			return res ;
		}
	}

	public List<DataEntity> faireLaRecherche1() { // pour chercher tous les informations 
		
		List<DataEntity> res = repo.findAll(); 
		if (res.size() == 0) {
			return null ;
		}else {
			return res ;
		}
	}

	public List<DataEntity> trouverDonnees1(int numOrder, Date dateArrive, String designation, String analyse, String division, Boolean table[]) {
		
			List<DataEntity> res = repo.findByAllSpecification(numOrder, dateArrive, designation, analyse, division, table) ;
			return res ;
	}
	
	public List<DataEntity> trouverDonnees2( Date dateDebut, Date dateFin ) {   // pour une information specifique
		List<DataEntity> res = repo.findByDateGreaterThanEqualAndDateLessThanEqual(dateDebut, dateFin) ;
		if (res.size() == 0) {
			return null ;
		}else {
			return res ;
		}
	}
	
	public List<DataEntity> trouverDonnees3( String designation ) {   // pour une information specifique
		List<DataEntity> res = repo.findByDesignation(designation) ;
		if (res.size() == 0) {
			return null ;
		}else {
			return res ;
		}
	}

	public List<DataEntity> trouverDonnees4( String division ) {   // pour une information specifique
			List<DataEntity> res = repo.findByDivision(division) ;
			return res ;
	}

}
