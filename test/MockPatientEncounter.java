package codesmell_tests;

import femr.data.models.core.*;

import java.util.ArrayList;
import java.util.List;

import femr.data.models.core.IPatientEncounter;
import org.joda.time.DateTime;

public  class MockPatientEncounter implements IPatientEncounter {

    private int id;
    private IPatient patient;
    private IUser nurse;
    private DateTime dateOfTriageVisit;

    private List<IChiefComplaint> chiefComplaints;
    private Integer weeksPregnant;
    private DateTime dateOfMedicalVisit;
    private DateTime dateOfPharmacyVisit;
    private IUser doctor;
    private IUser pharmacist;
    private IPatientAgeClassification patientAgeClassification;
    private  DateTime  dateOfDiabeteseScreen;
    private IMissionTrip missionTrip;
    private Boolean IsDiabetesScreened;




    public void setId(int id) {
        this.id = id;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public IPatient getPatient() {
        return patient;
    }

    @Override
    public void setPatient(IPatient patient) {
        this.patient = (IPatient) patient;
    }

    @Override
    public List<IChiefComplaint> getChiefComplaints() {
        List<IChiefComplaint> temp = new ArrayList<>();
        for (IChiefComplaint cc : chiefComplaints) {
            temp.add(cc);
        }
        return temp;
    }

    @Override
    public void setChiefComplaints(List<IChiefComplaint> chiefComplaints) {
        for (IChiefComplaint cc : chiefComplaints) {
            this.chiefComplaints.add((IChiefComplaint) cc);
        }
    }

    public Integer getWeeksPregnant() {
        return weeksPregnant;
    }

     public void setWeeksPregnant(Integer weeksPregnant) {
        this.weeksPregnant = weeksPregnant;
    }

    @Override
    public DateTime getDateOfTriageVisit() {
        return dateOfTriageVisit;
    }

    @Override
    public void setDateOfTriageVisit(DateTime dateOfTriageVisit) {
        this.dateOfTriageVisit = dateOfTriageVisit;
    }

    @Override
    public DateTime getDateOfMedicalVisit() {
        return dateOfMedicalVisit;
    }

    @Override
    public void setDateOfMedicalVisit(DateTime dateOfMedicalVisit) {
        this.dateOfMedicalVisit = dateOfMedicalVisit;
    }

    @Override
    public DateTime getDateOfPharmacyVisit() {
        return dateOfPharmacyVisit;
    }

    @Override
    public void setDateOfPharmacyVisit(DateTime dateOfPharmacyVisit) {
        this.dateOfPharmacyVisit = dateOfPharmacyVisit;
    }

    @Override
    public IUser getDoctor() {
        return doctor;
    }

    @Override
    public void setDoctor(IUser doctor) {
        this.doctor = (IUser) doctor;
    }

    @Override
    public IUser getPharmacist() {
        return pharmacist;
    }

    @Override
    public void setPharmacist(IUser pharmacist) {
        this.pharmacist = (IUser) pharmacist;
    }

    @Override
    public IUser getNurse() {
        return nurse;
    }

    @Override
    public void setNurse(IUser nurse) {
        this.nurse = (IUser) nurse;
    }

    @Override
    public IPatientAgeClassification getPatientAgeClassification() {
        return patientAgeClassification;
    }

    @Override
    public void setPatientAgeClassification(IPatientAgeClassification patientAgeClassification) {
        this.patientAgeClassification =  (IPatientAgeClassification) patientAgeClassification;
    }

    @Override
    public IMissionTrip getMissionTrip() {
        return missionTrip;
    }

    @Override
    public void setMissionTrip(IMissionTrip missionTrip) {
        this.missionTrip = missionTrip;
    }


    @Override
    public DateTime getDateOfDiabeteseScreen() {
        return dateOfDiabeteseScreen;
    }

    @Override
    public void setDateOfDiabeteseScreen(DateTime dateOfDiabeteseScreen) {
        this.dateOfDiabeteseScreen = dateOfDiabeteseScreen;
    }


    public Boolean getDiabetesScreened() {
        return IsDiabetesScreened;
    }

    public void setDiabetesScreened(Boolean diabetesScreened) {
        IsDiabetesScreened = diabetesScreened;
    }
    public IUser getDiabetesScreener() {
        return diabetesScreener;
    }

    public void setDiabetesScreener(IUser diabetesScreener) {
        this.diabetesScreener = diabetesScreener;
    }

    private IUser diabetesScreener;


    public Boolean getIsDiabetesScreened() {
        return IsDiabetesScreened ;
    }

    public void setIsDiabetesScreened(Boolean IsDiabetesScreened) {
        IsDiabetesScreened = IsDiabetesScreened;
    }


}

