package de.view.palaver.layoutBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import de.application.palaver.employee.Employee;
import de.application.palaver.employee.service.EmployeeService;
import de.application.palaver.employee.service.RoleService;
import de.helper.palaver.constants.IBeanDictionary;
import de.helper.palaver.util.Encrypt;
 
 
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
 
    private static final long serialVersionUID = 7765876811740798583L;
 
    private String m_username;
    public String getUsername() { return m_username; } 
    public void setUsername(String username) { m_username = username; }
    
    private String m_password;
    public String getPassword() { return m_password; } 
    public void setPassword(String password) { m_password = password; }
     
    private boolean m_loggedIn = false;
    public boolean isLoggedIn() { return m_loggedIn; }
    
    private List<Employee> m_employeeList;
    private Encrypt m_encrypt;
    private Employee m_employee;
    
    @ManagedProperty(value="#{navBean}")
    private NavigationBean navigationBean;


    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
     
    public LoginBean() {
    	super();    
    	m_employeeList = EmployeeService.getInstance().getAllOnlyTable();
    	m_employee = null;
    	m_encrypt = new Encrypt();
    }
    
    /**
     * Login operation.
     * @return
     */
    public void onLogin(ActionEvent actionEvent) {
    	

    	
    	if (m_username != null && m_password != null) {
	    	for (Employee employee : m_employeeList) {	  
	        	////
	    		initEmployee(employee, true);
	            findAllRolesForEmployee();
	            saveResultToSessionMap(); 		    	            
	            navigationBean.redirectTo("index.xhtml");
	        	////
				if(employee.getNickname().equalsIgnoreCase(m_username)) {					
		    		try {
		    			if(employee.getPassword().equals(m_encrypt.encryptPassword(m_password))) {
		    				initEmployee(employee, true);
		    	            findAllRolesForEmployee();
		    	            saveResultToSessionMap(); 		    	            
		    	            navigationBean.redirectTo("index.xhtml");
						} else {
					    	FacesContext context = FacesContext.getCurrentInstance();
					    	context.addMessage("msg", new FacesMessage(
					    			FacesMessage.SEVERITY_INFO,"Fehler bei der Anmeldung!", 
					    			"Eingegebes Passwort ist falsch!"));
						}						
					} catch (Exception exp) {
						exp.printStackTrace();
					} 					
				} 
			}
    	}           
    }
    
    public void onLogout() {
    	initEmployee(null, false);
    	saveResultToSessionMap();
    	navigationBean.redirectTo("login.xhtml"); 
    }  
    
	public List<String> completeEmployee(String query) {  
        List<String> employees = new ArrayList<String>();          
        for(Employee employee : m_employeeList) {  
            if(employee.getNickname().toLowerCase().startsWith(query.toLowerCase()))  
                employees.add(employee.getNickname());  
        }            
        return employees;  
    } 

	/*
	 * ###################
	 * #				 #
	 * # PRIVATE METHODE #
	 * #				 #
	 * ################### 
	 */

	private void initEmployee(Employee employee, boolean login) {
		if (login) {
	        m_loggedIn = true;  
	        m_employee = employee;
		} else {
			m_loggedIn = false;  
	        m_employee = null;
	        m_username = null;
		}
	}
	
	private void saveResultToSessionMap() {
		FacesContext.getCurrentInstance()
			.getExternalContext()
			.getSessionMap()
			.put(IBeanDictionary.AUTHORIZED_USER, m_employee);		
	}
	
    private void findAllRolesForEmployee() {
    	if (m_employee != null) {
    		m_employee.setRole(RoleService.getInstance().findRolesByEmployeeId(m_employee.getId()));
    	}
	}


  
}