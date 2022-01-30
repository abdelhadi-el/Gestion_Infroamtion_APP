package com.provApp.gestionApp.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.provApp.gestionApp.entities.PersonnelEntity;

@Component
public class PersonnelRepositoryCustomImpl implements PersonnelRepositoryCustom{
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<PersonnelEntity> findByAllSpecification(int identifiant, String userName, String type, Boolean table[]) {
		String numOrdText  ; String designText ; String analyText ; String query = "" ;

		if (table[0]) {
			if (table[1] || table[2] ) {
				numOrdText = "WHERE p.id = " + identifiant + " AND " ;
			}else {
				numOrdText = "WHERE p.id = " + identifiant ;
			}
		}else {
			numOrdText = "" ;
		}

		if (table[1]) {
			if (table[0] ) {
				if ( table[2] ) {
					designText = " p.userName = '" + userName + "'" + "AND" ; // "'" is for the query, if not it's unknown column
				}else {
					designText = " p.userName = '" + userName + "'" ;
				}
			}else {
				if ( table[2] ) {
					designText = " WHERE p.userName = '" + userName + "'" + "AND" ;
				}else {
					designText = " WHERE p.userName = '" + userName + "'";
				}
			}
			
		}else {
			designText = "" ;
		}
		if (table[2]) {
			if (table[0] || table[1] ) {
					analyText = " p.type = '" + type + "'";
			}else {
					analyText = "WHERE p.type = '" + type + "'" ;
			}
			
		}else {
			analyText = "" ;
		}

		query = "SELECT p FROM PersonnelEntity p " + numOrdText + designText + analyText ;
		 @SuppressWarnings("unchecked")
		TypedQuery<PersonnelEntity> queryJpa = (TypedQuery<PersonnelEntity>) entityManager.createQuery(query);
	        return queryJpa.getResultList();
			
		}
	@Transactional
	@Modifying(clearAutomatically = true)
	@Override
	public int updateByAllSpecification(int identifiant, int newIdentifiant, String userName, String password, String type) {
		Boolean exitingOrd  ;
		String query = "" ;
		if (newIdentifiant == -1) { // champ ord nouveau empty
			query = "UPDATE PersonnelEntity p SET p.userName =  :userN , p.password =  :pass "
					+ ", p.type = :type  WHERE p.id = :id ";
			exitingOrd = false ;
		}else {
			query = "UPDATE PersonnelEntity p SET  p.id = :id ,  p.userName =  :userN "
					+ ",  p.password = :pass ,  p.type =  :type  WHERE  p.id = :id1 ";
			exitingOrd = true ;
		}
		Query queryJpa = entityManager.createQuery(query);
        if (exitingOrd) {
            queryJpa.setParameter("id", newIdentifiant);
            queryJpa.setParameter("userN", userName);
            queryJpa.setParameter("pass", password);
            queryJpa.setParameter("type", type);
            queryJpa.setParameter("id1", identifiant);
		}else {
		    queryJpa.setParameter("userN", userName);
            queryJpa.setParameter("pass", password);
            queryJpa.setParameter("type", type);
            queryJpa.setParameter("id", identifiant);
		}
        return queryJpa.executeUpdate();
	}
	@Transactional
	@Modifying(clearAutomatically = true)
	@Override 
	public int addEntity(PersonnelEntity entity) {
		
			String query = "INSERT INTO personnel(id, user_name, password, Type) VALUES ( :id, :userN, :pass, :type ) " ;
			 Query queryJpa = entityManager.createNativeQuery(query);
	        queryJpa.setParameter("id", entity.getId());
	        queryJpa.setParameter("userN", entity.getUserName());
	        queryJpa.setParameter("pass", entity.getPassword());
	        queryJpa.setParameter("type", entity.getType());
	        return queryJpa.executeUpdate();
		
	}
}
