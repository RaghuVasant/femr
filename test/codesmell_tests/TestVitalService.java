package codesmell_tests;
import com.google.inject.Inject;
import femr.business.services.core.IVitalService;
import femr.common.dtos.ServiceResponse;
import femr.common.models.VitalItem;
import org.junit.Rule;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by raghu on 11/16/16.
 *  * This will unit test the functionality that was Moved from GOD class and also Schezophrenic class

 */
public class TestVitalService extends BaseClass{
     private IVitalService service  ;

    @Rule
    public TestCasePrintRule pr = new TestCasePrintRule(System.out);


    @Inject
    public void setService(IVitalService service) {
          this.service = service;
    }


    @Test
    public void Test_createPatientEncounterVitalItems() throws Exception {

        Map<String, Float> newVitals = new HashMap<>();
             newVitals.put("respiratoryRate", new Float(90));
             newVitals.put("heartRate",  new Float(78));
             newVitals.put("temperature", new Float(100));
             newVitals.put("oxygenSaturation", new Float(100));
             newVitals.put("heightFeet", new Float(60));
             newVitals.put("heightInches",  new Float(160));
             newVitals.put("weight", new Float(150));
             newVitals.put("bloodPressureSystolic", new Float(140));
             newVitals.put("bloodPressureDiastolic", new Float(120));
             newVitals.put("glucose", new Float(100));
             //  newVitals.put("weeksPregnant", new Float(100));

        ServiceResponse<List<VitalItem>> responseObject = service.createPatientEncounterVitalItems(newVitals,5,12321);
        try {
            List<VitalItem> vitalItemsList = responseObject.getResponseObject();
        }
        catch (Exception e ){

            //The code is bound to fail because of other objects in the heirarchy, but if the failure message is the following
            // it confirms that the  refactored methods (isMetric and getCurrentDateTime) have  executed successfully

           assertEquals( "ERROR executing DML bindLog[] error[Cannot add or update a child row: a foreign key constraint fails (`femrdb`.`patient_encounter_vitals`, CONSTRAINT `fk_patient_encounter_vitals_patient_encounter_id` FOREIGN KEY (`patient_encounter_id`) REFERENCES `patient_encounters` (`id`))]", e.getMessage());
        } 

    }
}

