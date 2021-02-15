package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PatientsList;
import util.Db;
import util.Query;

public class PatientListImp implements IPatientsList {

	PreparedStatement pst = null;
	ResultSet rs = null;
	int result = 0;

	@Override
	public int addnewpatient(PatientsList Lop) {
		try {
			pst = Db.getCon().prepareStatement(Query.addNewPatient);
			pst.setLong(1, Lop.getAdharNumber());
			pst.setString(2, Lop.getName());
			pst.setString(3, Lop.getBloodGroup());
			pst.setString(4, Lop.getStatus());
			pst.setString(5, Lop.getDistrict());
			pst.setLong(6, Lop.getMobile());
			result = pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			result = 0;

		}
		try {
			Db.getCon().close();
			pst.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<PatientsList> viewPatientList() {
		List<PatientsList> Lop = new ArrayList<PatientsList>();
		try {
			pst = Db.getCon().prepareStatement(Query.viewpatientdetails);
			rs = pst.executeQuery();
			while (rs.next()) {
				PatientsList list = new PatientsList(rs.getLong(1),rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), 
						rs.getLong(6));
				Lop.add(list);
			}

		} catch (ClassNotFoundException | SQLException e) {
			try {
				Db.getCon().close();
				pst.close();
				rs.close();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return Lop;
	}

	@Override
	public int editpatientdetails(PatientsList Lop) {
		try {
			pst = Db.getCon().prepareStatement(Query.editpatientdetails);
			pst.setLong(3, Lop.getAdharNumber());
			pst.setString(1, Lop.getStatus());
			pst.setLong(2, Lop.getMobile());

			result = pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			result = 0;
		} finally {
			try {
				Db.getCon().close();
				pst.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int removeRecoveryPatient(PatientsList Lop) {
		// TODO Auto-generated method stub
		try {
		      pst = Db.getCon().prepareStatement(Query.removepatient);
		      pst.setLong(1, Lop.getAdharNumber());
		      result = pst.executeUpdate();
		    } catch (ClassNotFoundException | SQLException e) {
		      result = 0;
		    } finally {
		      try {
		        Db.getCon().close();
		        pst.close();
		      } catch (ClassNotFoundException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      }
		    }
		return result;
	}

}
