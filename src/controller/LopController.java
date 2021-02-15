package controller;

import java.util.List;

import dao.IPatientsList;
import dao.PatientListImp;
import model.PatientsList;

public class LopController {
	IPatientsList lopImpl = new PatientListImp();

	  public int addnewpatient(Long adharNumber,String name,String bloodGroup,String status,String district,Long mobile) {
	    PatientsList Lop = new PatientsList(adharNumber,name, bloodGroup, status, district,mobile);
	    return lopImpl.addnewpatient(Lop);
	  }
	  public List<PatientsList> viewPatientList() {
		    return lopImpl.viewPatientList();
		  }

		  public int editpatientdetails(Long adharNumber,String status,Long mobile) {
			  PatientsList lop = new PatientsList(adharNumber,status,mobile);
		    return lopImpl.editpatientdetails(lop);
		  }

		  public int removeRecoveryPatient(Long adharNumber) {
			  PatientsList lop = new PatientsList();
		    lop.setAdharNumber(adharNumber);
		    return lopImpl.removeRecoveryPatient(lop);
		  }

}
