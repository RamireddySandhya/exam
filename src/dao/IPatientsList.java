package dao;

import java.util.List;

import model.PatientsList;

public interface IPatientsList {
	public int addnewpatient(PatientsList Lop);

	  public List<PatientsList> viewPatientList();

	  public int editpatientdetails(PatientsList Lop);

	  public int removeRecoveryPatient(PatientsList Lop);

}
