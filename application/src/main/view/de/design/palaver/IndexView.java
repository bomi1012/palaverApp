package de.design.palaver;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "index")
public class IndexView {

	public IndexView() {
		super();
	}
	
	public String getEmployeeInfo() {
//		Employee e = EmployeeService.getInstance().getEmployeeById(1L); 
//				return e.getFirstname() + " " + e.getLastname();
		
		return "Hallo, Thomas!";
	}
	

}
