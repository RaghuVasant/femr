package codesmell_tests; /**
 * Created by raghu on 11/15/16.
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteFemr  {



    public static void main(String[] args) {
             Result result = JUnitCore.runClasses(TestSearchServiceLocaleUnitConverter.class,
                                                    TestPatientItem.class,
                                                    TestReserachService.class,
                                                    TestVitalService.class,
                                                    TestPrescriptionItemModelMapper.class,
                                                    TestResearchController.class);

            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }

            System.out.println(result.wasSuccessful());
        }
    }

