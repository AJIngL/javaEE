package crm.com.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import crm.com.model.Person;
import crm.com.service.PersonService;

public class loginAction extends ActionSupport {
	ActionContext context = ActionContext.getContext();
	
	Person person = new Person();
	PersonService service = new PersonService();
	
	public PersonService getService() {
		return service;
	}

	public void setService(PersonService service) {
		this.service = service;
	}

	private Person p;

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}
	

	public void validate() {
		
		if(p.getPassword()==null || p.getPassword().equals("")){
			addFieldError("p.password", "请输入密码");
		}
		if(p.getUsername()==null || p.getUsername().equals("")){
			addFieldError("p.username", "用户名不能为空");
		}else{
			
			person = service.login(p.getUsername());
			if(person == null){
				addFieldError("p.username", "用户名不存在");
			}
			else if(!person.getPassword().equals(p.getPassword())) {
				addFieldError("p.password", "用户名或密码错误");
				context.getSession().put("username", p.getUsername());
			}
		}
		
	}
	
	@Override
	public String execute() throws Exception {
		
		context.getSession().put("username", p.getUsername());
		//context.getSession().put("password", p.getPassword());
		return SUCCESS;
	}
}
