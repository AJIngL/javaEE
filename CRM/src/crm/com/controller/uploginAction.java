package crm.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class uploginAction{
	
	
	public String execute() throws Exception {
		System.out.println("uploginAction");
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();  
		session.invalidate();
		
		return "success";
	}

}
