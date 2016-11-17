package femr.util.calculations;

import femr.common.models.PatientItem;
import femr.util.DataStructure.Mapping.VitalMultiMap;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by owner1 on 3/11/2015.
 */
public class SearchServiceLocaleUnitConverter {
    /**
     * Converts all imperial values in a PatientItem to metric values
     * @param patient PatientItem to get imperial values from and store metric values into
     * @return PatientItem with metric values
     */
    public static PatientItem toMetric(PatientItem patient) {
        if (patient == null) return patient;

        // Store seperate height variables temporarily
        // Wish getHeightFeet() and getHeightInches() were'nt stored as Integer in PatientItem.
        // Causes issues with precision when value stored in database as a non whole number
        if (patient.getHeightFeet() != null && patient.getHeightInches() != null) {
            Integer feet = patient.getHeightFeet();
            Integer inches = patient.getHeightInches();

            //added for femr-136 - dulal unit display
            patient.setHeightFeetDual(patient.getHeightFeet());
            patient.setHeightInchesDual(patient.getHeightInches());

            // Overwrite patient height feet with meters
            patient.setHeightFeet(LocaleUnitConverter.getMeters(feet, inches));

            // Overwrite patient height inches with centimeters
            patient.setHeightInches(LocaleUnitConverter.getCentimetres(feet, inches));
        }

        // Overwrite patients weight with kg
        if (patient.getWeight() != null) {
            patient.setWeight(LocaleUnitConverter.getKgs(patient.getWeight()).floatValue());
            //added for femr-136 - dual unit display
            patient.setWeightDual(LocaleUnitConverter.getLbs(patient.getWeight()));
        }
        return patient;
    }
    /**
     * Added for femr-136 - dual unit display
     * Converts all imperial values in a PatientItem to metric values for dual unit display
     * @param patient PatientItem to get imperial values from and store metric values into
     * @return PatientItem with metric values
     */

    public static PatientItem forDualUnitDisplay(PatientItem patient) {
        if (patient == null) return patient;

        // Store seperate height variables temporarilyl
        // Wish getHeightFeet() and getHeightInches() were'nt stored as Integer in PatientItem.
        // Causes issues with precision when value stored in database as a non whole number
        if (patient.getHeightFeet() != null && patient.getHeightInches() != null) {
            Integer feet = patient.getHeightFeet();
            Integer inches = patient.getHeightInches();

            // Overwrite patient height feet with meters
            patient.setHeightFeetDual(LocaleUnitConverter.getMeters(feet, inches));

            // Overwrite patient height inches with centimeters
            patient.setHeightInchesDual(LocaleUnitConverter.getCentimetres(feet, inches));
        }

        // Overwrite patients weight with kg
        if (patient.getWeight() != null) {
            patient.setWeightDual(LocaleUnitConverter.getKgs(patient.getWeight()).floatValue());
        }
        return patient;
    }

}
