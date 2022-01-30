package com.provApp.gestionApp.controlleurs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.entities.PersonnelEntity;
import com.provApp.gestionApp.persistence.PersonnelRepository;

import lombok.NoArgsConstructor;

@Component @NoArgsConstructor @Scope("prototype")
public class ChercherPersonnel{

	Boolean userExist ;
	PersonnelRepository repo ;
	
	public Boolean getUserExist() {
		return userExist;
	}

	@Autowired
	public ChercherPersonnel( PersonnelRepository repo ) throws FileNotFoundException, IOException {
		super() ;
		this.repo = repo ;
	}
	
	public Boolean checkUser( String userName, String password, int type ) throws SQLException {  //for login // pour une information specifique
		String typeString ;
		if (type == 0) {
			typeString = "administrateur";
		}else {
			typeString = "normal" ;
		}
		if (repo.findByUserNameAndPasswordAndType(userName, password, typeString).isEmpty()) { // calling method in repository
			return false ;
		}else {
			return true ;
		}
	}

	public Object[] faireLaRecherche( int identifiant ) {   // pour une information specifique
		Optional<PersonnelEntity> result =  repo.findById(identifiant) ;
		Object[] resultTable = new Object[4];

 		if (result.isEmpty()) {
			return null ;
		}else {
			resultTable[0] = result.get().getId() ;
			resultTable[1] = result.get().getUserName() ;
			resultTable[2] = result.get().getPassword() ;
			resultTable[3] = result.get().getType() ;
			return resultTable ;
		}
	}
	public Optional<PersonnelEntity> checkExistenceById( int identifiant ) {
			Optional<PersonnelEntity> result =  repo.findById(identifiant) ;
			return result ;
	}

	public List<PersonnelEntity> faireLaRecherche1() { // pour chercher tous les informations 
		
			List<PersonnelEntity> persoList = repo.findAll() ;
			return persoList ;
	}


	public List<PersonnelEntity> trouverDonnees3( String userName ) {   // pour une username
		
			List<PersonnelEntity> listPerso = repo.findByUserName(userName) ;
			return listPerso ;
	}

	public List<PersonnelEntity> trouverDonnees4( String type ) {   // pour une information specifique
		
			List<PersonnelEntity> listPerso = repo.findByType(type) ;
			return listPerso ;
	}

	public List<PersonnelEntity> findPersoToSet(int identifiant, String userName, String type, Boolean table[]) {
		
			List<PersonnelEntity> res = repo.findByAllSpecification(identifiant, userName, type, table) ;
			return res ;
	}

}
