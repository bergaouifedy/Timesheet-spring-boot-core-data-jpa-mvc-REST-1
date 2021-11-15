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
import tn.esprit.spring.entities.Departement;
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
	

	

	private static final Logger logger = Logger.getLogger(EmployeServiceImpl.class);
	
	
	public int ajouterEmploye(Employe employe) {
		try {
			logger.info("ajouter employer ");
			logger.debug("je vais ajouter un employé");
			employeRepository.save(employe);

			logger.debug("je vien ajouter un employé");
			logger.info("employe ajouter sont erreur");
			
			
		}
		 catch (Exception e) {logger.error("Erreur : " + e);}
	
		return employe.getId();
	}

	
	
	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		Employe x = new Employe ();
		try {
		logger.info("employe existe");	
		logger.debug("mis a jour mail");
		Optional<Employe> y = employeRepository.findById(employeId) ;
		if (y.isPresent())
		{
			x = y.get();
		}
		
	    
		x.setEmail(email);
		logger.info("mis a jour mail avec Succès");
	
		employeRepository.save(x);
		logger.info("mis a jour sans erreur");
		}catch (Exception e) {
			logger.error("Erreur avec la  mis a jour   email " +e);
		}
	}

	

	


	
		public String getEmployePrenomById(int employeId) {
			
				Employe x = new Employe();
				try{
					logger.info("affichage d'une employe par id : ");
					logger.debug("entrain d'afficher employe : ");
					
					
					Optional<Employe> y = employeRepository.findById(employeId) ;
					if (y.isPresent())
					{
						x = y.get();
					}
										
					logger.debug("je viens d'afficher employe: ");
					logger.info("affichage sans erreurs " );
				}
				catch(Exception e){
					logger.error("Erreur dans l'affichage de employe: "+e);
				}finally{
					logger.info("Methode affichage");
			
				
				
			
				}
			return x.getPrenom();
		}
		
		
		
		
	public void deleteEmployeById(int employeId)
	
	{ 
		Employe employe = new Employe ();
		try {
		logger.info("suppression d'un employe ");
		logger.debug("selection du emoloye a supprimé");
		
		Optional<Employe> y = employeRepository.findById(employeId) ;
		if (y.isPresent())
		{
		
			
			for(Departement dep : employe.getDepartements()){
				dep.getEmployes().remove(employe);
			}
		}
		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association
		
		logger.debug("suppression de employe ");
		employeRepository.delete(employe);
		logger.debug("je viens de supprimer un employe");
		logger.info("suppression without errors");
	}
		
	catch(Exception e){
		logger.error("Erreur dans l'affectation du employe : "+e);
	}
	}

	/*public int ajouterContrat(Contrat contrat) {
		
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
	*/
	

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


	
	/*public void deleteContratById(int contratId) {
		
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
	}*/
	
	
}
