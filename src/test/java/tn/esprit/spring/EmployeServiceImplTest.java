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
import tn.esprit.spring.utils.BaseJUnit49TestCase;

public class EmployeServiceImplTest extends BaseJUnit49TestCase {
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
	int idE;



	

	
	
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
		public void testaffecterContratAEmploye() {		
			LOG.info("In testaffecterContratAEmploye()");
			int contratId = 4; 
			Contrat cont = contratRepoistory.findById(contratId).orElse(null);
			Employe emp = empRepoistory.findById(idE).orElse(null);
			if(cont!=null)
				{
					cont.setEmploye(emp);
					iempServ.affecterContratAEmploye(contratId, idE);
					
				}
				 Assert.assertNotNull("contrat null",cont);
				 LOG.info("Out testaffecterContratAEmploye()");
			}
	

}
