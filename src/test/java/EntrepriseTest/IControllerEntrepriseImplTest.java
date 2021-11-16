package EntrepriseTest;

import org.junit.Assert;
import org.junit.Test;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;

public class IControllerEntrepriseImplTest {
	
	EntrepriseServiceImpl eerviceimp = new EntrepriseServiceImpl() ;
	Entreprise e = new Entreprise();
	
	@Test
	public void testAjouterEntreprise() {
		e.setId(2);
		e.setName("fatma");
		e.setRaisonSocial("coding");
		Assert.assertNotNull("Name mustn't be null", e.getName());
		Assert.assertNotNull("Raison Social mustn't be null", e.getRaisonSocial());
		eerviceimp.ajouterEntreprise(e);
		
	}
	
	@Test
	public void testDeleteEntrepriseById()
	{
		int id = 0;
		int pid = e.getId();
		Assert.assertEquals(pid, id);
		eerviceimp.deleteEntrepriseById(id);
		
	}
	
	@Test
	public void testGetEntrepriseById()
	{
		int id = 0;
		int pid = e.getId();
		Assert.assertEquals(pid, id);
		eerviceimp.getEntrepriseById(id);
		
	}

}
