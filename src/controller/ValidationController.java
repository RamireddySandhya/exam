package controller;

import dao.IValidation;
import dao.ValidationImp;
import model.Validation;

public class ValidationController {
	IValidation ivalidation = new ValidationImp();

	  public int authenticate(String name, String password) {  
	    Validation admin = new Validation(name, password);
	    return ivalidation.Authenticate(admin);

}
}
