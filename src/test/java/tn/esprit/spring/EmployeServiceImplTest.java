package tn.esprit.spring;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.IEmployeService;



public class EmployeServiceImplTest  {
	private static final Logger LOG = LogManager.getLogger(EmployeServiceImplTest.class);
	
	Employe e = new Employe();

	@Autowired
	IEmployeService iempServ;
	
	@Autowired
	EmployeRepository empRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	private Employe employe;
	private Contrat contrat;



	
	
		@Test
		public void testAjouterEmploye () {

			e.setPrenom("xxx");
			e.setNom("dihek");
			e.setEmail("dihek.missaoui@gmail.com");
			e.setActif(true);
			Assert.assertNotNull("Name mustn't be null", e.getNom());
			
			iempServ.ajouterEmploye( e);
		}
		@Test
	public void testAffecterContratAEmploye() {

		LOG.info("Start Method affecterContratAEmploye");
		LOG.info(this.contrat);
		LOG.info(this.employe);

		iempServ.affecterContratAEmploye(5, 1);
		Assert.assertEquals(this.employe.getContrat().getReference(), this.contrat.getReference());


		LOG.info("End Method affecterContratAEmploye");
	}
	

		//mala 
		
		//chy ifaded
}
