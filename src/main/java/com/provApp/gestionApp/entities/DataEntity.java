package com.provApp.gestionApp.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Entity @Scope("prototype")
@Table(name = "arrivee" ) @Data
public class DataEntity {

	@Id
	@Column(name = "OrdreAnnuel")
	@ColumnDefault("")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "dateArrivee")
	private Date date;
	@Column(name = "DesignationExpediteur")
	private String designation ;
	@Column(name = "AnalyseAffaire")
	private String analyse ;
	@Column(name = "Division")
	private String division ;
}
