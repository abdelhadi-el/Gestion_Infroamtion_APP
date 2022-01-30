package com.provApp.gestionApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Entity @Scope("prototype")
@Table(name = "personnel" ) @Data
public class PersonnelEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "userName")
	private String userName ;
	@Column(name = "password")
	private String password ;
	@Column(name = "type")
	private String type ;
}
