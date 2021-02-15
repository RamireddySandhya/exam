package view;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controller.LopController;
import controller.ValidationController;
import customexception.Customexception;
import model.PatientsList;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		try {

			Scanner scan = new Scanner(System.in);
			System.out.println("Enter username");
			String name = scan.nextLine();
			System.out.println("Enter password");
			String password = scan.nextLine();
			ValidationController vController = new ValidationController();
			int result = 0;

			result = vController.authenticate(name, password);
			LopController lcontroller = new LopController();
			if (result == 1) {
				System.out.println("Hi " + name);
				System.out.println("Admin Optins are  ");
				System.out.println(
						"1)Add New Patient\n2)View All patient detaild\n3)Delete recovery patient\n4)Update patient details");
				String cont;
				do {

					System.out.println("Enter your option");
					int option = scan.nextInt();
					switch (option) {
					case 1:
						System.out.println("Enter patient adharNumber,patientname,bloodgroup,status of patient ,district,mobile no");
						scan.nextLine();
						String details[] = scan.nextLine().split(",");
						result = lcontroller.addnewpatient(Long.parseLong(details[0]), details[1], details[2], details[3],details[4],
								Long.parseLong(details[5]));
						if (result == 1) {
							System.out.println(details[0] + " patient details added successfully");
						} else {
							System.out.println(details[0] + " was patient details not added successfully");
						}
						break;

					case 2:
						scan.nextLine();
						System.out.println("people Info");
						List<PatientsList> list = lcontroller.viewPatientList();
						for (PatientsList lop : list) {
							System.out.println(lop);
						}
						if (list.size() == 0) {
							System.out.println("No records found!!!");
						}
						break;
					case 3:
						scan.nextLine();
						System.out.println("Enter recovery patient adharNumber for remove");
						String adharNumber = scan.nextLine();

						result = lcontroller.removeRecoveryPatient(Long.parseLong(adharNumber));
						if (result == 1) {
							System.out.println(adharNumber + "patient removed successfully");
						} else {
							System.out.println(adharNumber + " patient was not removed successfully");
						}
						scan.nextLine();
						break;
					case 4:
						System.out.println("Enter adharNumber,status,mobileno");
						scan.nextLine();
						String det1[] = scan.nextLine().split(",");
						result = lcontroller.editpatientdetails(Long.parseLong(det1[0]), det1[1], Long.parseLong(det1[2]));
						if (result == 1) {
							System.out.println(det1[0] + "  patient information updated successfully");
						} else {
							System.out.println(det1[0] + " patient information was not updated successfully");
						}
						break;
					default:
						System.out.println("Invalid Option");
					}
					System.out.println("Do you want to continue(yes/no)");
					cont = scan.nextLine();
				} while (cont.equalsIgnoreCase("yes"));
			} else {
				System.out.println("Username or Password Went Wrong");
			}
			System.out.println("Thank you for using this application");
			scan.close();
		} catch (InputMismatchException | NumberFormatException e) {
			invokeCustomException();
		}
	}

	public static void invokeCustomException() {
		try {
			throw new Customexception();
		} catch (Customexception e) {
			System.out.println(e);
		}

	}

}
