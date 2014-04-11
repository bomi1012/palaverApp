package de.view.palaver.layoutBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import de.application.palaver.employee.Employee;
import de.application.palaver.employee.service.EmployeeService;
import de.helper.palaver.constants.IBeanDictionary;
 
 
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
    
    private Employee m_employee;
    private List<Employee> m_employees;
    
	private Employee m_selectedEmployee;
    public Employee getSelectedEmployee() { return m_selectedEmployee; }
    public void setSelectedEmployee(Employee selectedEmployee) { m_selectedEmployee = selectedEmployee; }  
 
    
    
    @ManagedProperty(value="#{navBean}")
    private NavigationBean navigationBean;


    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
     
    public LoginBean() {
    	super();    
    	m_employees = EmployeeService.getInstance().getAll();
    }
    
    /**
     * Login operation.
     * @return
     */
    public String onLogin() {
    	m_username = "Kai";
    	m_password = "12";
    	m_employee = EmployeeService.getInstance().findEmployee(m_username, m_password);
        if (m_username != null && m_password != null) {
            m_loggedIn = true;
            saveResultToSessionMap();            
            return navigationBean.redirectToIndex();
        }
        return navigationBean.redirectToLogin();         
    }
    
    public List<Employee> completeEmployee(String query) {  
        List<Employee> employees = new ArrayList<Employee>();          
        for(Employee employee : m_employees) {  
            if(employee.getNickname().startsWith(query))  
                employees.add(employee);  
        }            
        return employees;  
    } 
 
    
    
	private void saveResultToSessionMap() {
		FacesContext.getCurrentInstance()
			.getExternalContext()
			.getSessionMap()
			.put(IBeanDictionary.LOGIN_IN_SESSION, m_loggedIn);		
	}
	


//    /**
//     * Logout operation.
//     * @return
//     */
//    public String doLogout() {
//        // Set the paremeter indicating that user is logged in to false
//        loggedIn = false;
//         
//        // Set logout message
//        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
//        msg.setSeverity(FacesMessage.SEVERITY_INFO);
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//         
//        return navigationBean.toLogin();
//    }    
}