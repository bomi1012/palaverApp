package de.application.palaver.employee.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import de.application.palaver.employee.Employee;
import de.application.palaver.recipe.Recipe;

@ManagedBean(name = "emp")
public class EmployeeManager implements IEmployeeManager{

	public EmployeeManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getEmployeeInfo() {
		//FIXME: beispiel ohne DB;
		List<Recipe> list = new ArrayList<Recipe>();
		Employee employee = new Employee(1L, "Mischa", "Muster", "bomi", list);
		 
		return "Vorname: " + employee.getFirstname() + " Nachname: " + employee.getLastname() +
				 " Spitzname: " + employee.getNickname();
	}

}
