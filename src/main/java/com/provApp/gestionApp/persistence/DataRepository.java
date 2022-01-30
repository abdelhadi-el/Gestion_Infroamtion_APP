package com.provApp.gestionApp.persistence;

import java.sql.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.entities.DataEntity;

@Component @Scope("prototype")
public interface DataRepository extends JpaRepository<DataEntity, Integer>, DataRepositoryCustom{
	List<DataEntity> findByDateGreaterThanEqualAndDateLessThanEqual(Date value1,Date value2);
	List<DataEntity> findByDesignation( String designation );
	List<DataEntity> findByDivision( String division );
}
