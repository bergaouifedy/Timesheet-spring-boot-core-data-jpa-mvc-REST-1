package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;

@RestController
public class RestControlEmploye {

	
	@Autowired
	IEmployeService iemployeservice;


	
	// http://localhost:8081/SpringMVC/servlet/ajouterEmployer
	//{"id":1,"nom":"kallel", "prenom":"khaled", "email":"Khaled.kallel@ssiiconsulting.tn", "isActif":true, "role":"INGENIEUR"}
	
	@PostMapping("/ajouterEmployer")
	@ResponseBody
	public Employe ajouterEmploye(@RequestBody Employe employe)
	{
		iemployeservice.ajouterEmploye(employe);
		return employe;
	}
	
	
	// http://localhost:8081/SpringMVC/servlet/ajouterContrat
	//{"reference":6,"dateDebut":"2020-03-01","salaire":2000,"typeContrat":"CDD"}
	@PostMapping("/ajouterContrat")
	@ResponseBody
	public int ajouterContrat(@RequestBody Contrat contrat) {
		iemployeservice.ajouterContrat(contrat);
		return contrat.getReference();
	}
	
	// http://localhost:8081/SpringMVC/servlet/affecterContratAEmploye/6/1
   @PutMapping(value = "/affecterContratAEmploye/{idcontrat}/{idemp}") 
	public void affecterContratAEmploye(@PathVariable("idcontrat")int contratId, @PathVariable("idemp")int employeId)
	{
		iemployeservice.affecterContratAEmploye(contratId, employeId);
	}

	
       
 // URL : http://localhost:8081/SpringMVC/servlet/deleteContratById/2
    @DeleteMapping("/deleteContratById/{idcontrat}") 
	@ResponseBody
	public void deleteContratById(@PathVariable("idcontrat")int contratId) {
		iemployeservice.deleteContratById(contratId);
	}

    

    // URL : http://localhost:8081/SpringMVC/servlet/deleteAllContratJPQL
    @DeleteMapping("/deleteAllContratJPQL") 
	@ResponseBody
	public void deleteAllContratJPQL() {
		iemployeservice.deleteAllContratJPQL();
		
	}

	
}
