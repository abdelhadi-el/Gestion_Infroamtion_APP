package com.provApp.gestionApp.persistence;

import java.sql.Date;
import java.util.List;

import com.provApp.gestionApp.entities.DataEntity;

public interface DataRepositoryCustom {

	List<DataEntity> findByAllSpecification( int numOrder, Date dateArrive, String designation, String analyse, String division, Boolean table[] );
	int updateByAllSpecification( int ordAnn, int newOrdAnn,Date dateArr, String desig, String analyse, String division );
	int addEntity(DataEntity entity) ;
}
