package com.provApp.gestionApp.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.entities.PersonnelEntity;

@Component @Scope("prototype")
public interface PersonnelRepository extends JpaRepository<PersonnelEntity, Integer>, PersonnelRepositoryCustom{

	Optional<PersonnelEntity> findByUserNameAndPasswordAndType(String userName, String password, String type);
	List<PersonnelEntity> findByUserName( String userName ) ; 
	List<PersonnelEntity> findByType( String type ) ; 
}
