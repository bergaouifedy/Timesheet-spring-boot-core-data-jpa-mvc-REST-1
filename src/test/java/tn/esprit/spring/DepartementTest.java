package tn.esprit.spring;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.utils.BaseJUnit49TestCase;

public class DepartementTest extends BaseJUnit49TestCase {
	
	private static final Logger LOG = LogManager.getLogger(DepartementTest.class);

	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	IEntrepriseService ientrepriseservice;
	
	private Entreprise entreprise;
	private Departement departement;
	
	@Override
    public void setUp() throws Exception {
        super.setUp();
        this.departement = new Departement();
        this.departement.setName("DATA SC DEPARTEMENT");

        this.entreprise = new Entreprise();
        this.entreprise.setName("TESLA");
        this.entreprise.setRaisonSocial("100000TUN103");
    }
	
	
	
	@Test
	public void deleteDepartementByIdTest() {
		LOG.info("-------------------------- Start Method Delete Departement By Id ------------------------");
		LOG.info("The Dep will be deleted is : " , this.departement);
		ientrepriseservice.ajouterDepartement(this.departement);
		LOG.info(this.departement.getId());
		ientrepriseservice.deleteDepartementById(this.departement.getId());
		LOG.info(this.departement.getId());
		Assert.assertFalse(deptRepoistory.findById(this.departement.getId()).isPresent());
		LOG.info(" Delete Departement By Id has been finished successfuly ");
		LOG.info("-------------------------- Method By Id has been finished successfuly ---------------------");

	}
	
	@Test
	public void ajouterDepartementTest() {
		LOG.info("--------------------- Start Method ADD Departement ------------------------");
		LOG.info(this.departement);
		ientrepriseservice.ajouterDepartement(departement);
		Assert.assertTrue(ientrepriseservice.ajouterDepartement(departement) > 0);
		LOG.info("Departement has been Added successfly");
		LOG.info("--------------------- End Method ADD Departement --------------------------");
	}
	

}
