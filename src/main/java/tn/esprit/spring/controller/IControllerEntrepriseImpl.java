package tn.esprit.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;
import org.apache.log4j.Logger;

@Controller
public class IControllerEntrepriseImpl{
	
	private static final Logger logger = Logger.getLogger(IControllerEntrepriseImpl.class);

	@Autowired
	IEntrepriseService ientrepriseservice;

	public int ajouterEntreprise(Entreprise ssiiConsulting) {
		logger.info("**********");
		logger.info("Ajouter Entreprise");
		try{
			logger.info("voila*");
			ientrepriseservice.ajouterEntreprise(ssiiConsulting);
			logger.info("**********");
		}catch (Exception e) {
			logger.error("Erreur : " + logger.getLevel());
		}
		
		return ssiiConsulting.getId();
	}
	
	public void deleteEntrepriseById(int entrepriseId)
	{
		ientrepriseservice.deleteEntrepriseById(entrepriseId);
	}
	public Entreprise getEntrepriseById(int entrepriseId) {

		return ientrepriseservice.getEntrepriseById(entrepriseId);
	}

}
