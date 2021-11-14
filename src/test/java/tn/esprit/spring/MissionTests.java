package tn.esprit.spring;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.LogManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import tn.esprit.spring.TimesheetSpringBootCoreDataJpaMvcRest1Application;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetSpringBootCoreDataJpaMvcRest1Application.class)
public class MissionTests {
	@Autowired
	ITimesheetService tServ;

@Autowired
ITimesheetService ts;
@Autowired
MissionRepository ms ;
@Autowired
DepartementRepository ds;

Mission mission = new Mission();

Departement departement = new Departement();

@Test
public void ajouterMissionTest(){
	mission.setDescription("nouvelle mission");
	mission.setName("mission A");
	assertNotNull("name mustn't be null", mission.getName());
	tServ.ajouterMission(mission);
	
		
}
@Test
public void affecterMissionADepartementTest(){
	
	

mission.setName("deplacement");
	Departement departement = new Departement("info");
	 mission.setDepartement(departement);
	assertNotNull("departement mustn't be null", mission.getDepartement());	
}

/*@Test
public void TestgetAllEmployeByMission(){
	
	
}*/


}
