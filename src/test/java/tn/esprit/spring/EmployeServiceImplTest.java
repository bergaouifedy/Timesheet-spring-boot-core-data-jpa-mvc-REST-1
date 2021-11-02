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

	@Autowired
	IEmployeService iempServ;
	
	@Autowired
	EmployeRepository empRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	private Employe employe;
	private Contrat contrat;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.employe = new Employe();
		this.employe.setId(getIdHelper().createRandomInt());
		this.employe.setPrenom("tarek");
		this.employe.setNom("chehidi");
		this.employe.setEmail("tarek.chehidi@esprit.tn");
		this.employe.setActif(true);
		this.employe.setRole(Role.INGENIEUR);
		this.contrat = new Contrat();
		//this.contrat.setReference(getIdHelper().createRandomInt());

	}

	@Test
	public void tests() {
		//testAjouterEmploye();
		//testAjouterContrat();
		//testAffecterContratAEmploye();
       // testDeleteContratByRef();
	}
	
	public void testAjouterEmploye(){
		this.employe.setPrenom("Fedi");
		this.employe.setNom("bergaoui");
		this.employe.setEmail("fedi.bergaoui@esprit.tn");
		this.employe.setActif(true);
		this.employe.setRole(Role.INGENIEUR);
		this.employe.setId(iempServ.ajouterEmploye(employe));
		Assert.assertTrue(employe.getId()>0);
	}
	
	
		public void testAjouterContrat() {
		LOG.info("Start Method testAjouterContrat");
		LOG.info(this.contrat);
		this.contrat.setEmploye(this.employe);

		this.contrat.setReference(iempServ.ajouterContrat(this.contrat));
		Assert.assertTrue(contrat.getReference() > 0);
		LOG.info("End Method testAjouterContrat");

	}

	public void testAffecterContratAEmploye() {

		LOG.info("Start Method affecterContratAEmploye");
		LOG.info(this.contrat);
		LOG.info(this.employe);

		iempServ.affecterContratAEmploye(5, 1);
		Assert.assertEquals(this.employe.getContrat().getReference(), this.contrat.getReference());


		LOG.info("End Method affecterContratAEmploye");
	}
	

		public void testDeleteContratByRef() {
		LOG.info("Start Method deleteContratByRef");
		LOG.info(this.contrat);

		iempServ.deleteContratById(this.contrat.getReference());
		Optional<Contrat> cont = contratRepoistory.findById(this.contrat.getReference());
//		System.out.println(cont.get().getReference());
//		Assert.assertTrue(cont.isPresent());

		LOG.info("End deleteContratByRef");

	}

}