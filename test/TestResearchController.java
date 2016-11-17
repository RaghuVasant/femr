package codesmell_tests;

/**
 * Created by raghu on 11/16/16.
 * this test is verify the refactored Feature Envy type of class
 */
import femr.business.services.core.IMedicationService;
import femr.business.services.core.IMissionTripService;
import femr.business.services.core.IResearchService;
import femr.business.services.system.MissionTripService;
import femr.business.services.system.ResearchService;
import femr.business.services.system.SessionService;
import femr.ui.controllers.ResearchController;
import org.junit.Test;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.mock;

public class TestResearchController extends BaseClass {

   private final SessionService sessionService = mock(SessionService.class);
    private final IResearchService researchService = mock(ResearchService.class);
    private final IMedicationService medicationService = mock(IMedicationService.class);
    private final IMissionTripService missionTripService = mock(MissionTripService.class);

    private final ResearchController researchController = new ResearchController(sessionService,researchService,medicationService,missionTripService );




  @Test

    public void Test_indexPost() {

           Map<String,String> formData = new HashMap();

            Calendar cal = BaseClass.calendarFor(2016, Calendar.OCTOBER, 18);
            Date theStartDate = cal.getTime();
            cal = BaseClass.calendarFor(2016, Calendar.OCTOBER, 28);
            Date theEndtDate = cal.getTime();

              formData.put("primaryDataset", "age");
              formData.put("secondaryDataset", "medication");
              formData.put("graphType", "Bar Graph");
              formData.put(" startDate", theStartDate.toString());
              formData.put("endDate", theEndtDate.toString());
              formData.put("secondaryDataset", "medication");


            Http.RequestBuilder requestBuilder = new Http.RequestBuilder().bodyForm(formData);
            Helpers helpers = new Helpers();
            Result result1 = helpers.invokeWithContext(
                    Helpers.fakeRequest().bodyText("some request body here"),
                    researchController::indexPost);
            assertEquals(result1,"OK");



        }



}
