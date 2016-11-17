
/**
 * Created by raghu on 11/16/16. This test is intended to test the refactored code for the type 'duplication'.
 * The buildSecondaryData method which is common duplicated code  from buildVitalResultSet,buildMedicalResultSet and buildAgeResultset
 */
package codesmell_tests;

import femr.business.services.core.IResearchService;
import femr.business.services.system.ResearchService;
import femr.common.dtos.ServiceResponse;
import femr.common.models.ResearchFilterItem;
import femr.common.models.ResearchResultSetItem;
import femr.data.daos.IRepository;
import femr.data.daos.Repository;
import femr.data.models.core.IPatientEncounterTabField;
import femr.data.models.core.IVital;
import femr.data.models.core.research.IResearchEncounter;
import org.junit.Rule;
import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.mock;

public class TestReserachService extends BaseClass{


   private final  Repository<IResearchEncounter> researchEncounterRepository = mock(Repository.class);
    private final IRepository<IVital> vitalRepository = mock(Repository.class);
    private final IRepository<IPatientEncounterTabField> patientEncounterTabFieldRepository = mock(Repository.class);
    private IResearchService researchService = new ResearchService(researchEncounterRepository,vitalRepository,patientEncounterTabFieldRepository);

  //  @Inject
    //public void setResearchService(IResearchService researchService) {
    //      this.researchService = researchService;
    //}

    @Rule
    public TestCasePrintRule pr = new TestCasePrintRule(System.out);


    @Test
    public void Test_buildVitalResultSet() throws Exception {


        ResearchFilterItem researchFilterItem = new ResearchFilterItem();
        researchFilterItem.setEndDate("10/30/2016");
        researchFilterItem.setGraphType("Bar Graph");
        researchFilterItem.setPrimaryDataset("age");
        researchFilterItem.setSecondaryDataset("Gender");
        researchFilterItem.setMedicationName("Tea");


        ServiceResponse<ResearchResultSetItem> resultSetItemServiceResponse= researchService.retrieveGraphData(researchFilterItem );
        ResearchResultSetItem itemResponse = resultSetItemServiceResponse.getResponseObject();
        Map<String, String> errorList = resultSetItemServiceResponse.getErrors();

        assertEquals( 0,  errorList.size() );




    }
}

