package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;



@Controller
public class IControllerEmployeImpl  {
	private static final Logger logger = Logger.getLogger(IControllerEmployeImpl.class);
	@Autowired
	IEmployeService iemployeservice;
	

	
	public int ajouterEmploye(Employe employe)
	{
		try {
			logger.info("ajouter employer ");
			
			iemployeservice.ajouterEmploye(employe);
		}
		 catch (Exception e) {logger.error("Erreur : " + e);}
		
		return employe.getId();
	}
    
	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		iemployeservice.mettreAjourEmailByEmployeId(email, employeId);
		
	}


	

	
	


	
	public String getEmployePrenomById(int employeId) {
		return iemployeservice.getEmployePrenomById(employeId);
	}

	
	public void deleteEmployeById(int employeId) {
		iemployeservice.deleteEmployeById(employeId);
		
	}
	
	
	public int ajouterContrat(Contrat contrat) {
		iemployeservice.ajouterContrat(contrat);
		return contrat.getReference();
	}
	
	public void affecterContratAEmploye(int contratId, int employeId)
	{
		iemployeservice.affecterContratAEmploye(contratId, employeId);
	}

		public void deleteContratById(int contratId) {
		iemployeservice.deleteContratById(contratId);
	}


	public void deleteAllContratJPQL() {
		iemployeservice.deleteAllContratJPQL();
		
	}

	
}
