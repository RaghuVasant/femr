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

import java.util.Date;

public interface IIPatientItemModelMapper {
    /**
     * Generate and provide an instance of PatientItem. See parameter descriptions for which fields must be filled out.
     *
     * @param id                 id of the patient, not null
     * @param firstName          first name of the patient, not null
     * @param lastName           last name of the patient, not null
     * @param city               city that the patient lives in, not null
     * @param address            address of the patient, may be null
     * @param userId             id of the user that checked in the patient in triage, not null
     * @param age                age of the patient, may be null
     * @param isAgeReal
     * @param sex                sex of the patient, may be null
     * @param weeksPregnant      how many weeks pregnant the patient is, may be null
     * @param heightFeet         how tall the patient is, may be null
     * @param heightInches       how tall the patient is, may be null
     * @param weight             how much the patient weighs, may be null
     * @param pathToPatientPhoto filepath to the patient photo, may be null
     * @param photoId            id of the patients photo, may be null
     * @param ageClassification  age classification of the patient (adult,child, etc), may be null
     * @return a new PatientItem or null if processing fails, may be null
     */
    PatientItem createPatientItem(int id,
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
                                  String ageClassification);

    /**
     * Generate and provide an instance of PatientEncounterItem
     *
     * @param patientEncounter patient encounter info, not null
     * @return a new PatientEncounterItem or null if processing fails
     */
    PatientEncounterItem createPatientEncounterItem(IPatientEncounter patientEncounter);


}
