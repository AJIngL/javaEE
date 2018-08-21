package crm.com.controller;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import crm.com.model.Person;


public class isLoginAction extends ActionSupport{
	private Person p;
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	
	@Override
	public String execute(){
		if(p.getUsername()==null){
			return ERROR;
		}
		ActionContext context = ActionContext.getContext();
		context.getSession().put("username", p.getUsername());
		return SUCCESS;
	}
}
