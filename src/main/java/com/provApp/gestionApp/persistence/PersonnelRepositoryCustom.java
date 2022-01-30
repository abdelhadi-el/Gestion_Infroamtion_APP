package com.provApp.gestionApp.persistence;

import java.util.List;

import com.provApp.gestionApp.entities.PersonnelEntity;

public interface PersonnelRepositoryCustom {
	List<PersonnelEntity> findByAllSpecification( int identifiant, String userName, String type, Boolean table[] );
	int updateByAllSpecification( int identifiant,int newIdentifiant, String userName, String password, String type);
	int addEntity(PersonnelEntity entity) ;
}
