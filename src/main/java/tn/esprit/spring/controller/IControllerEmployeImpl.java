package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;



@Controller
public class IControllerEmployeImpl  {
	@Autowired
	IEmployeService iemployeservice;

	public int ajouterEmploye(Employe employe)
	{
		iemployeservice.ajouterEmploye(employe);
		return employe.getId();
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
