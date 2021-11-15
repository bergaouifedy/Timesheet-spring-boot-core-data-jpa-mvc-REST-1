package tn.esprit.spring;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.TimesheetRepository;
import tn.esprit.spring.services.TimesheetServiceImpl;

import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class TimesheetServiceImplTest {



    @Mock
    private TimesheetRepository timesheetRepository;

    @InjectMocks
    private TimesheetServiceImpl timesheetService;

    private Timesheet timesheet;
    private TimesheetPK timesheetPK;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ajouterTimesheetTest() {
        TimesheetPK timesheetPK = new TimesheetPK();
        timesheetPK.setDateDebut(new Date(1504095567183L));
        timesheetPK.setDateFin(new Date());
        timesheetPK.setIdEmploye(1);
        timesheetPK.setIdMission(2);
        Timesheet timesheet = new Timesheet();
        timesheet.setTimesheetPK(timesheetPK);
        timesheet.setValide(false);
        // assertEquals(0, timesheetRepository.count());

        //  timesheetService.ajouterTimesheet(2,1,timesheetPK.getDateDebut(),timesheetPK.getDateFin());
        // assertEquals(1, timesheetRepository.count());


        when(timesheetRepository.save(timesheet)).thenReturn(timesheet);
        timesheetService.ajouterTimesheet(2,1,timesheetPK.getDateDebut(),timesheetPK.getDateFin());
        verify(timesheetRepository,times(1)).save(any());


    }

    @AfterEach
    public void tearDown() {
        timesheetPK   = null;
        timesheet = null;
    }


}
