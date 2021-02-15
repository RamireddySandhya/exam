package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Validation;
import util.Db;
import util.Query;

public class ValidationImp implements IValidation {

	PreparedStatement pst = null;
	ResultSet rs = null;
	int result = 0;

	@Override
	public int Authenticate(Validation validation) {
		// TODO Auto-generated method stub

		try {
			pst = Db.getCon().prepareStatement(Query.validationauthentication);
			pst.setString(1, validation.getName());
			pst.setString(2, validation.getPassword());
			rs = pst.executeQuery();

			while (rs.next()) {
				result++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Db.getCon().close();
			pst.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
