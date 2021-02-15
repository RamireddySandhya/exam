package util;

public class Query {
	public static String validationauthentication = "select * from validation where name=? and password=?";
	public static String addNewPatient = "insert into patients_list values(?,?,?,?,?,?)";
	public static String viewpatientdetails = "select *from patients_list";
	public static String editpatientdetails = "update  patients_list set status=?,mobile=? where adharNumber=?";
	  public static String removepatient = "delete from patients_list where name=?";
}