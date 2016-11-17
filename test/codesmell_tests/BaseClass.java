package codesmell_tests; /**
 * Created by raghu on 11/15/16.
 */import femr.common.dtos.ServiceResponse;
import femr.util.dependencyinjection.modules.BusinessLayerModule;
import femr.util.dependencyinjection.modules.DataLayerModule;
import femr.util.dependencyinjection.modules.MapperModule;
import femr.util.dependencyinjection.modules.UtilitiesModule;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import play.test.FakeApplication;
import play.test.Helpers;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.fail;

import java.util.Calendar;
import utils.GuiceJUnitRunner;


/**
 * Created by ojcch on 3/14/2016.
 */
@RunWith(GuiceJUnitRunner.class)
@GuiceJUnitRunner.GuiceModules({BusinessLayerModule.class, DataLayerModule.class, MapperModule.class, UtilitiesModule.class})
public class BaseClass {

    public static FakeApplication app;

    @BeforeClass
    public static void startApp() {

        Map<String, Object> conf = conf = new HashMap<>();

        conf.put(  "db.default.url","jdbc:mysql://localhost:3306/femrdb?characterEncoding=UTF-8");
        conf.put(  "db.default.username","femruser");
        conf.put(  "db.default.password","femruser");
        conf.put( "ebean.default", "models.*, femr.data.models.*");
        conf.put(  "play.evolutions.db.default.enabled","false");
        conf.put(  "play.evolutions.enabled","false");

        app = Helpers.fakeApplication(conf);
        Helpers.start(app);
    }

    @AfterClass
    public static void stopApp() {
        Helpers.stop(app);
    }

    public static void checkForErrors(ServiceResponse response){
        Map<String, String> errs = response.getErrors();

        if (errs.size() != 0){
            fail(errs.toString());
        }

    }



        public static Calendar calendarFor(int year, int month, int day) {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month);
            cal.set(Calendar.DAY_OF_MONTH, day);
            return cal;
        }

}