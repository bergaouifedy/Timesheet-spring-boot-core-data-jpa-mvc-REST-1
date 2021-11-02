package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;

import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {
	
	private static final Logger l = Logger.getLogger(EmployeServiceImpl.class);

	@Autowired
	EmployeRepository employeRepository;
	
	@Autowired
	ContratRepository contratRepoistory;
	
	public int ajouterEmploye(Employe employe) {
		employeRepository.save(employe);
		return employe.getId();
	}


	public int ajouterContrat(Contrat contrat) {
		
		try{
			l.info("Ajout du contrat");
			
			l.debug("je VAIS ajouter un contrat : ");
			contratRepoistory.save(contrat);
			l.debug("je viens  de finir l'ajout d'un contrat : ");

			l.info("contrat ajouté without errors : ");
		}catch (Exception e) {
			l.error("Erreur dans l'ajout du contrat : " +e);
		}
		return contrat.getReference();
	}
	
	

	public void affecterContratAEmploye(int contratId, int employeId) {
		Contrat contrat = null;
		Employe employe = null;
		try
		{
			l.info("Affectation du contrat a employe : ");
			l.debug("Selection du contrat : ");
			Optional<Contrat> contratManagedEntity = contratRepoistory.findById(contratId);	
			l.debug("Contrat selectionné : ");
			l.debug("Selection de l'employe");
			Optional<Employe> employeManagedEntity = employeRepository.findById(employeId);
			l.debug("employe selectionné : ");
			if(contratManagedEntity.isPresent())
			{
				contrat = contratManagedEntity.get();
				if(employeManagedEntity.isPresent())
				{
				employe = employeManagedEntity.get();
				l.debug("Affecter contrat a employe : ");
				contrat.setEmploye(employe);
				contratRepoistory.save(contrat);
				l.info("Contrat affecte a employe without errors : ");
				}
			}	
			
		}catch (Exception e) {
			l.error("Erreur dans l'affectation du contrat : " +e);
		}
		
		
	}


	
	public void deleteContratById(int contratId) {
		
		Contrat contrat = new Contrat();
		try{
			
			
			l.info("suppression d'un contrat : ");
			l.debug("selection du contrat a supprimé : ");
			Optional<Contrat> contratManagedEntity = contratRepoistory.findById(contratId);
			if(contratManagedEntity.isPresent())
			{
				contrat = contratManagedEntity.get();
				l.debug("suppression du contrat : ");
				contratRepoistory.delete(contrat);
				l.debug("je viens de supprimer un contrat : ");
				
				l.info("suppression without errors : " );

				
			}
				}catch(Exception e){
			l.error("Erreur dans l'affectation du contrat: "+e);
		}
		

	}

		public void deleteAllContratJPQL() {
		try{
			l.info("Suppression de tout les contrats : ");
			
			l.debug("Je vais supprimer tous les contrats : ");
	         employeRepository.deleteAllContratJPQL();
				l.debug("Je viens de supprimer tous les contrats : ");

				l.info("Contrats supprimes without errors : ");

		}catch (Exception e) {
			l.error("Erreur dans la suppression de tous les contrats : " +e);
		}
	}
	
	
}
