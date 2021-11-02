package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;



public interface IEmployeService {
	
	public int ajouterEmploye(Employe employe);
	public int ajouterContrat(Contrat contrat);
	public void affecterContratAEmploye(int contratId, int employeId);
	public void deleteContratById(int contratId);
	public void deleteAllContratJPQL();	
	
	

	
}
