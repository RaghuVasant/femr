package codesmell_tests;

import femr.business.services.system.EncounterService;
import femr.common.IIPatientItemModelMapper;
import femr.common.PatientItemModelMapper;
import femr.common.dtos.ServiceResponse;
import femr.common.models.PatientEncounterItem;
import femr.common.models.PatientItem;
import femr.util.calculations.dateUtils;
import org.junit.Rule;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.mock;


/**
 * Created by raghu on 11/15/16.
 * This will unit test the functionality that was Moved from GOD class
 */
public class TestPatientItem  extends BaseClass{




    /**
     * Created by raghu on 11/15/16.
     */


    private static EncounterService encounterService;

    public static void setEncounterService(EncounterService encounterService) {
        TestPatientItem.encounterService = encounterService;
    }

    @Rule
    public TestCasePrintRule pr = new TestCasePrintRule(System.out);







    @Test
        public void Test_createPatient() throws Exception {
            PatientItem patient = new PatientItem();
            //required fields
            patient.setId(12555);
            patient.setFirstName("test");
            patient.setLastName("user");

            Calendar cal = BaseClass.calendarFor(2010, Calendar.MAY, 21);
            Date theDate = cal.getTime();

            patient.setYearsOld(dateUtils.getYearsInteger(theDate));
            patient.setMonthsOld(dateUtils.getMonthsInteger(theDate));
            patient.setCity("Morne De L' Hopital");
            patient.setAddress("");
            patient.setUserId(5);
            IIPatientItemModelMapper pModelMapper = new PatientItemModelMapper();
           PatientItem p2 = pModelMapper.createPatientItem(patient.getId(),patient.getFirstName(), patient.getLastName(),patient.getCity(), patient.getAddress(),patient.getUserId(),
           theDate,1, "M",0,5,5,new Float(150),"",0,"");

            assertEquals (patient.getFirstName(),p2.getFirstName());
            assertEquals (patient.getLastName(),p2.getLastName());
            assertEquals (patient.getYearsOld(),p2.getYearsOld());
            assertEquals (patient.getMonthsOld(),p2.getMonthsOld());
            assertEquals (patient.getCity(),p2.getCity());
            assertEquals (patient.getUserId(),p2.getUserId());
         }


    @Test
    public void Test_createPatientEncounterItem() throws Exception {
         int patientId=12310;
         int userId=5;
        int tripId=5;
        String ageClassification="";
        List<String> chiefComplaints=null;

          ServiceResponse<PatientEncounterItem> response =
                  encounterService.createPatientEncounter(patientId,   userId,   tripId,   ageClassification,   chiefComplaints) ;
         PatientEncounterItem patientEncounterItem = response.getResponseObject();


        assertNotNull(patientEncounterItem);



        }



}


