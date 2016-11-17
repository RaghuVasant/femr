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

import femr.util.stringhelpers.StringUtils;

import femr.common.IItemModelMapper;
import femr.common.IPrescriptionItemModelMapper;
import org.joda.time.DateTime;

import java.text.DecimalFormat;

/**
 * Responsible for creating item objects (common/models)
 * Only visible to ui & service layer.
 */
public class PrescriptionItemModelMapper implements IPrescriptionItemModelMapper {

    /**
     * /**
     * {@inheritDoc}
     */
    @Override
    public PrescriptionItem createPrescriptionItem(int id, String name, String originalMedicationName, String firstName, String lastName,
                                                   IConceptPrescriptionAdministration medicationAdministration, Integer amount, IMedication medication,
                                                   MedicationInventory medicationInventory, Boolean isCounseled) {


        PrescriptionItem prescriptionItem = new PrescriptionItem();
        IItemModelMapper itemModelMapper = new ItemModelMapper();

        prescriptionItem.setId(id);
        prescriptionItem.setName(name);
        if (originalMedicationName != null)
            prescriptionItem.setOriginalMedicationName(originalMedicationName);
        if (StringUtils.isNotNullOrWhiteSpace(firstName))
            prescriptionItem.setPrescriberFirstName(firstName);
        if (StringUtils.isNotNullOrWhiteSpace(lastName))
            prescriptionItem.setPrescriberLastName(lastName);

        if (medicationAdministration != null) {
            prescriptionItem.setAdministrationID(medicationAdministration.getId());
            prescriptionItem.setAdministrationName(medicationAdministration.getName());
            prescriptionItem.setAdministrationModifier(medicationAdministration.getDailyModifier());
        }
        prescriptionItem.setAmount(amount);

        if (isCounseled != null)
            prescriptionItem.setCounseled(isCounseled);

        if (medication != null) {

            MedicationItem medicationItem;
           if (medicationInventory != null) {

                medicationItem = itemModelMapper.createMedicationItem(medication, medicationInventory.getQuantityCurrent(), medicationInventory.getQuantityInitial(), null);
                prescriptionItem.setMedicationRemaining(medicationInventory.getQuantityCurrent());
            } else {
                medicationItem = itemModelMapper.createMedicationItem(medication, null, null, null);
            }

            prescriptionItem.setMedicationID(medicationItem.getId());

            if (medicationItem.getForm() != null)
                prescriptionItem.setMedicationForm(medicationItem.getForm());

            if (medicationItem.getActiveIngredients() != null)
                prescriptionItem.setMedicationActiveDrugs(medicationItem.getActiveIngredients());
        }
        return prescriptionItem;
    }
}
