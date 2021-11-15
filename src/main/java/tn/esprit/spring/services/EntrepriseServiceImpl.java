package tn.esprit.spring.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
import java.util.Optional;
import org.apache.log4j.Logger;
@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	
	private static final Logger logger = Logger.getLogger(EntrepriseServiceImpl.class);
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	public int ajouterEntreprise(Entreprise entreprise) {
		logger.info("**********");
		
		try{
			logger.info("Ajouter Entreprise");
			logger.debug("je suis entrain d'ajouter une entreprise");
			entrepriseRepoistory.save(entreprise);
			logger.info("entreprise ajoutee");
		}catch (Exception e) {
			logger.error("Erreur : " + logger.getLevel());
		}finally{
			logger.info("Methode ajouter entreprise fini");
		}
	
		return entreprise.getId();
	}
	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
			
			try{
				
				logger.info("suppression d'une entreprise : ");
				logger.debug("selection d'une entreprise a supprimé : ");
				Optional<Entreprise> y = entrepriseRepoistory.findById(entrepriseId) ;
				if (y.isPresent())
				{
					entrepriseRepoistory.delete(y.get());
				}
				logger.debug("je viens de supprimer entreprise: ");
				logger.info("suppression sans erreurs " );
			}catch(Exception e){
				logger.error("Erreur dans la suppression de l'entreprise: "+e);
			}finally{
				logger.info("Methode supprimer entreprise fini");
			}
			
	}

	public Entreprise getEntrepriseById(int entrepriseId) {
		Entreprise x = new Entreprise();
		try{
			logger.info("affichage d'une entreprise par id : ");
			logger.debug("entrain d'afficher entreprise : ");
			Optional<Entreprise> y = entrepriseRepoistory.findById(entrepriseId) ;
			if (y.isPresent())
			{
				x = y.get();
			}
			
			logger.debug("je viens d'afficher entreprise: ");
			logger.info("affichage sans erreurs " );
		}
		catch(Exception e){
			logger.error("Erreur dans l'affichage de l'entreprise: "+e);
		}finally{
			logger.info("Methode affichage entreprise fini");
		}
		return x;	
	}

}
