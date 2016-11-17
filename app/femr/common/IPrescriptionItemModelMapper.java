/*
     fEMR - fast Electronic Medical Records
     Copyright (C) 2014  Team fEMR

     fEMR is free software: you can redistribute it and/or modify
     it under the terms of the GNU General Public License as published by
     the Free Software Foundation, either version 3 of the License, or
     (at your option) any later version.

     fEMR is distributed in the hope that it will be useful,
     but WITHOUT ANY WARRANTY; without even the implied warranty of
     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     GNU General Public License for more details.

     You should have received a copy of the GNU General Public License
     along with fEMR.  If not, see <http://www.gnu.org/licenses/>. If
     you have any questions, contact <info@teamfemr.org>.
*/
package femr.common;

import femr.common.models.*;
import femr.data.models.core.*;
import femr.data.models.mysql.MedicationInventory;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;

public interface IPrescriptionItemModelMapper {


    /**
     * Generate and provide an instance of PrescriptionItem
     *
     * @param id            id of the prescription, not null
     * @param name          name of the prescription, not null
     * @param originalMedicationName original prescription that replaced this prescription, may be null
     * @param firstName     first name of the person that prescribed the medication, may be null
     * @param lastName      last name of the person that prescribed the medication, may be null
     * @param conceptPrescriptionAdministration
     * @param amount
     * @param medication
     * @param medicationInventory the inventory of the medication, may be null
     * @param isCounseled indicates whether or not the pharmacist checked the checkbox indicating that they counseled the patient on this prescription, may be null
     * @return a new PrescriptionItem or null if processing fails
     */
    PrescriptionItem createPrescriptionItem(int id, String name, String originalMedicationName, String firstName, String lastName,
                                            IConceptPrescriptionAdministration conceptPrescriptionAdministration, Integer amount,
                                            IMedication medication, MedicationInventory medicationInventory, Boolean isCounseled);


}
