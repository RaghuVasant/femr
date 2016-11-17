package codesmell_tests;

/**
 * Created by raghu on 11/16/16.
 *  * This will unit test the functionality that was Moved from GOD class
 */
import com.google.inject.Inject;
import femr.business.services.core.IMedicationService;
import femr.business.services.core.ISearchService;
import femr.business.services.system.SearchService;
import femr.common.*;
import femr.common.dtos.ServiceResponse;
import femr.common.models.MedicationItem;
import femr.common.models.PrescriptionItem;
import femr.data.daos.IRepository;
import femr.data.daos.Repository;
import femr.data.models.core.*;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.mock;

public class TestPrescriptionItemModelMapper  extends BaseClass{


    private final  Repository<IConceptDiagnosis> conceptDiagnosisRepository = mock(Repository.class);
    private final IRepository<IPatient> patientIRepository = mock(Repository.class);
    private final IRepository<IMissionTrip> missionTripIRepository = mock(Repository.class);
    private final IRepository<IPatientEncounter> patientEncounterIRepository = mock(Repository.class);
    private final IRepository<IPatientEncounterVital> patientEncounterVitalIRepository = mock(Repository.class);
    private final IRepository<IPatientPrescription> patientPrescriptionIRepository = mock(Repository.class);
    private final IRepository<ISystemSetting> systemSettingIRepository = mock(Repository.class);
    private final IRepository<IPatientPrescriptionReplacement> patientPrescriptionReplacementIRepository = mock(Repository.class);
    private final IRepository<IMissionCity> missionCityIRepository = mock(Repository.class);
    private final  IIPatientItemModelMapper patientItemModelMapper = mock(PatientItemModelMapper.class);
    private final IPrescriptionItemModelMapper prescriptionItemModelMapper=mock(PrescriptionItemModelMapper.class);
    private final ItemModelMapper itemModelMapper =mock(ItemModelMapper.class);


    private ISearchService searchService = new  SearchService(conceptDiagnosisRepository,
                                                                missionTripIRepository,
                                                                patientIRepository,
                                                                patientEncounterIRepository,
                                                                patientEncounterVitalIRepository,
                                                                patientPrescriptionIRepository,
                                                                systemSettingIRepository,
                                                                patientPrescriptionReplacementIRepository,
                                                                missionCityIRepository,
                                                                patientItemModelMapper,
                                                                prescriptionItemModelMapper,
                                                                itemModelMapper);

    private static IMedicationService medicationService;

    @Inject
    public void setService(IMedicationService medicationService) {
        this.medicationService = medicationService;
    }



    //  @Inject
    //public void setResearchService(IResearchService researchService) {
    //      this.researchService = researchService;

    //}

    @Rule
    public TestCasePrintRule pr = new TestCasePrintRule(System.out);

@Test
    public void retrieveDispensedPrescriptionItems() throws Exception {
        ServiceResponse<List<PrescriptionItem>>  response= searchService.retrieveDispensedPrescriptionItems(1626);
       List<PrescriptionItem> result = response.getResponseObject();
        Map<String, String> errorList = response.getErrors();

    assertEquals(0,  errorList.size() );
    }


    @Test
    public void   createPrescriptionWithNewMedication() throws Exception{
        ServiceResponse<MedicationItem> response = medicationService.createMedication("TylenolExtraStrength", "medForm", null);

        MedicationItem medicine = response.getResponseObject();
        assertEquals("TylenolExtraStrength", medicine.getName());

    }

}
