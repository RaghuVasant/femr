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

import femr.business.helpers.LogicDoer;
import femr.common.IIPatientItemModelMapper;
import femr.common.models.*;
import femr.data.models.core.*;
 import femr.util.calculations.dateUtils;
import femr.util.stringhelpers.StringUtils;

 import java.util.Date;

/**
 * Responsible for creating item objects (common/models)
 * Only visible to ui & service layer.
 */
public class PatientItemModelMapper implements IIPatientItemModelMapper {


    /**
     * {@inheritDoc}
     */
    @Override
    public PatientItem createPatientItem(int id,
                                         String firstName,
                                         String lastName,
                                         String city,
                                         String address,
                                         int userId,
                                         Date age,
                                         Integer isAgeReal,
                                         String sex,
                                         Integer weeksPregnant,
                                         Integer heightFeet,
                                         Integer heightInches,
                                         Float weight,
                                         String pathToPatientPhoto,
                                         Integer photoId,
                                         String ageClassification) {

        if (StringUtils.isNullOrWhiteSpace(firstName) ||
                StringUtils.isNullOrWhiteSpace(lastName) ||
                StringUtils.isNullOrWhiteSpace(city)) {

            return null;
        }

        PatientItem patientItem = new PatientItem();

        //required fields
        patientItem.setId(id);
        patientItem.setFirstName(firstName);
        patientItem.setLastName(lastName);
        patientItem.setYearsOld(dateUtils.getYearsInteger(age));
        patientItem.setMonthsOld(dateUtils.getMonthsInteger(age));
        patientItem.setCity(city);
        patientItem.setUserId(userId);
        //optional fields
        if (StringUtils.isNotNullOrWhiteSpace(address))
            patientItem.setAddress(address);
        if (StringUtils.isNotNullOrWhiteSpace(sex))
            patientItem.setSex(sex);
        if (age != null) {

            patientItem.setAge(dateUtils.getAge(age));//age (int)
            patientItem.setIsAgeReal(isAgeReal);
            patientItem.setBirth(age);//date of birth(date)
            patientItem.setFriendlyDateOfBirth(dateUtils.getFriendlyDate(age));

        }
        if (StringUtils.isNotNullOrWhiteSpace(pathToPatientPhoto) && photoId != null) {

            patientItem.setPathToPhoto(pathToPatientPhoto);
            patientItem.setPhotoId(photoId);
        }
        if (weeksPregnant != null)
            patientItem.setWeeksPregnant(weeksPregnant);

        if (heightFeet != null)
            patientItem.setHeightFeet(heightFeet);
        else
            patientItem.setHeightFeet(0);

        if (heightInches != null)
            patientItem.setHeightInches(heightInches);
        else
            patientItem.setHeightInches(0);

        if (weight != null)
            patientItem.setWeight(weight);

        return patientItem;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PatientEncounterItem createPatientEncounterItem(IPatientEncounter patientEncounter) {

        if (patientEncounter == null || patientEncounter.getPatient() == null) {

            return null;
        }

        PatientEncounterItem patientEncounterItem = new PatientEncounterItem();

        for (IChiefComplaint cc : patientEncounter.getChiefComplaints()) {

            patientEncounterItem.addChiefComplaint(cc.getValue());
        }
        patientEncounterItem.setId(patientEncounter.getId());
        patientEncounterItem.setPatientId(patientEncounter.getPatient().getId());

        if (patientEncounter.getMissionTrip() != null) {
            patientEncounterItem.setMissionTripId(patientEncounter.getMissionTrip().getId());
        }

        patientEncounterItem.setTriageDateOfVisit(dateUtils.getFriendlyDate(patientEncounter.getDateOfTriageVisit()));
        if (patientEncounter.getDateOfMedicalVisit() != null)
            patientEncounterItem.setMedicalDateOfVisit(dateUtils.getFriendlyDate(patientEncounter.getDateOfMedicalVisit()));
        if (patientEncounter.getDateOfPharmacyVisit() != null)
            patientEncounterItem.setPharmacyDateOfVisit(dateUtils.getFriendlyDate(patientEncounter.getDateOfPharmacyVisit()));
        patientEncounterItem.setIsClosed(LogicDoer.isEncounterClosed(patientEncounter));
        patientEncounterItem.setNurseEmailAddress(patientEncounter.getNurse().getEmail());
        if (patientEncounter.getDoctor() != null)
            patientEncounterItem.setPhysicianEmailAddress(patientEncounter.getDoctor().getEmail());
        if (patientEncounter.getPharmacist() != null)
            patientEncounterItem.setPharmacistEmailAddress(patientEncounter.getPharmacist().getEmail());
        patientEncounterItem.setNurseFullName(patientEncounter.getNurse().getFirstName() + " " + patientEncounter.getNurse().getLastName()); // Andrew Change
        //checks if the patient has been screened for diabetes during this encounter
        if (patientEncounter.getDateOfDiabeteseScreen() != null)
            patientEncounterItem.setScreenedForDiabetes(true);
        else
            patientEncounterItem.setScreenedForDiabetes(false);

        if (patientEncounter.getDoctor() != null) {
            patientEncounterItem.setPhysicianFullName(patientEncounter.getDoctor().getFirstName() + " " + patientEncounter.getDoctor().getLastName()); // Andrew Change
        }
        if (patientEncounter.getPharmacist() != null) {
            patientEncounterItem.setPharmacistFullName(patientEncounter.getPharmacist().getFirstName() + " " + patientEncounter.getPharmacist().getLastName()); // Andrew Change
        }
        return patientEncounterItem;

    }
}
