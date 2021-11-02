package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Employe;


public interface EmployeRepository extends CrudRepository<Employe, Integer>  {
	
 
    @Modifying
    @Transactional
    @Query("DELETE from Contrat")
    public void deleteAllContratJPQL();
   
	
    		
   

}
