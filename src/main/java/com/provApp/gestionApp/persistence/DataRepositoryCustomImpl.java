package com.provApp.gestionApp.persistence;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.provApp.gestionApp.entities.DataEntity;

@Component
public class DataRepositoryCustomImpl implements DataRepositoryCustom{

	  @PersistenceContext
	    private EntityManager entityManager;
	  
	@Override
	public List<DataEntity> findByAllSpecification(int numOrder, Date dateArrive, String designation, String analyse,
			String division, Boolean[] table) {
		String numOrdText ; String dateArrText ; String designText ; String analyText ; String divisText ; String query = "" ;
		
		if (table[0]) {
			if (table[1] || table[2] || table[3] || table[4]) {
				numOrdText = "WHERE a.id = '" + numOrder + "' AND " ;
			}else {
				numOrdText = "WHERE a.id = '" + numOrder + "'" ;
			}
		}else {
			numOrdText = "" ;
		}
		if (table[1]) {				// should handle the case when we click two times at "chercher" one field mask the other
			LocalDate localDate = dateArrive.toLocalDate();
			if (table[0]) {
				if ( table[2] || table[3] || table[4]) { // if an query is already existed we should not have a where at first for the others !!! important !!! not solved  
					dateArrText = " YEAR( a.date ) = " + localDate.getYear() + " AND MONTH( a.date ) = " + localDate.getMonthValue() + " AND DAY( a.date ) = " + localDate.getDayOfMonth() + " AND " ;
				}else {
					dateArrText = " YEAR( a.date ) = " + localDate.getYear() + " AND MONTH( a.date ) = " + localDate.getMonthValue() + " AND DAY( a.date ) = " + localDate.getDayOfMonth() ;
				}
			}else {
				if ( table[2] || table[3] || table[4]) { // if an query is already existed we should not have a where at first for the others !!! important 
					dateArrText = "WHERE YEAR( a.date ) = " + localDate.getYear() + " AND MONTH( a.date ) = " + localDate.getMonthValue() + " AND DAY( a.date ) = " + localDate.getDayOfMonth() + " AND " ;
				}else {
					dateArrText = "WHERE YEAR( a.date ) = " + localDate.getYear() + " AND MONTH( a.date ) = " + localDate.getMonthValue() + " AND DAY( a.date ) = " + localDate.getDayOfMonth() ;
				}
			}
			
		}else {
			dateArrText = "" ;
		}
		if (table[2]) {
			if (table[0] || table[1]) {
				if ( table[3] || table[4]) {
					designText = " a.designation = '" + designation + "'" + "AND" ; // "'" is for the query, if not it's unknown column
				}else {
					designText = " a.designation = '" + designation + "'" ;
				}
			}else {
				if ( table[3] || table[4]) {
					designText = " WHERE a.designation = '" + designation + "'" + "AND" ;
				}else {
					designText = " WHERE a.designation = '" + designation + "'";
				}
			}
			
		}else {
			designText = "" ;
		}
		if (table[3]) {
			if (table[0] || table[1] || table[2]) {
				if ( table[4]) {
					analyText = " a.analyse = '" + analyse + "'" + "AND" ;
				}else {
					analyText = " a.analyse = '" + analyse + "'";
				}
			}else {
				if ( table[4]) {
					analyText = "WHERE a.analyse = '" + analyse + "'" +  "AND" ;
				}else {
					analyText = "WHERE a.analyse = '" + analyse + "'" ;
				}
			}
			
		}else {
			analyText = "" ;
		}
		if (table[4]) {
			if (table[0] || table[1] || table[2] || table[3]) {
				divisText = " a.division = '" + division + "'"  ;
			}else {
				divisText = " WHERE a.division = '" + division + "'" ;
			}
		}else {
			divisText = "" ;
		}
		
		query = "select a FROM DataEntity a " + numOrdText + dateArrText + designText + analyText + divisText ;	
        @SuppressWarnings("unchecked")
		TypedQuery<DataEntity> queryJpa = (TypedQuery<DataEntity>) entityManager.createQuery(query);
        return queryJpa.getResultList();

	}
	@Transactional
	@Modifying(clearAutomatically = true)
	@Override
	public int updateByAllSpecification(int ordAnn, int newOrdAnn, Date dateArr, String desig,
			String analyse, String division) {
		Boolean exitingOrd  ;
		String query = "" ;
		if (newOrdAnn == -1) { // champ ord nouveau empty
			query = "UPDATE DataEntity a SET  a.date =  :date , a.designation =  :desig "
					+ ", a.analyse =  :analyse , a.division =  :div  WHERE a.id = :id ";
			exitingOrd = false ;
		}else {
			query = "UPDATE DataEntity a SET a.id = :id , a.date =  :date ,  a.designation  =  :desig "
					+ ", a.analyse  =  :analyse , a.division =  :div  WHERE a.id = :id1 ";
			exitingOrd = true ;
		}
        Query queryJpa = entityManager.createQuery(query);
        if (exitingOrd) {
            queryJpa.setParameter("id", newOrdAnn);
            queryJpa.setParameter("date", dateArr);
            queryJpa.setParameter("desig", desig);
            queryJpa.setParameter("analyse", analyse);
            queryJpa.setParameter("div", division);
            queryJpa.setParameter("id1", ordAnn);
		}else {
		    queryJpa.setParameter("date", dateArr);
            queryJpa.setParameter("desig", desig);
            queryJpa.setParameter("analyse", analyse);
            queryJpa.setParameter("div", division);
            queryJpa.setParameter("id", ordAnn);
		}
        return queryJpa.executeUpdate();
		
	}
	@Transactional
	@Modifying(clearAutomatically = true)
	@Override 
	public int addEntity(DataEntity entity) {
		String query = "INSERT INTO arrivee(ordre_annuel, date_arrivee, designation_expediteur, analyse_affaire, Division) VALUES ( :id, :date, :desig, :analyse, :div ) " ;
		 Query queryJpa = entityManager.createNativeQuery(query);
        queryJpa.setParameter("id", entity.getId());
        queryJpa.setParameter("date", entity.getDate());
        queryJpa.setParameter("desig", entity.getDesignation());
        queryJpa.setParameter("analyse", entity.getAnalyse());
        queryJpa.setParameter("div", entity.getDivision());
        return queryJpa.executeUpdate();
	}
}
