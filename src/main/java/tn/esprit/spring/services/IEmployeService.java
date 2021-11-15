package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;



public interface IEmployeService {
	

	public int ajouterEmploye(Employe employe);
	public void mettreAjourEmailByEmployeId(String email, int employeId);
	


	public String getEmployePrenomById(int employeId);
	public void deleteEmployeById(int employeId);

	public void affecterContratAEmploye(int contratId, int employeId);

	
	
	

	
}
