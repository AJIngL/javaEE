package crm.com.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import crm.com.dao.PersonDao;
import crm.com.model.Person;
import crm.com.service.PersonService;

public class changePwdAction extends ActionSupport{
	
	Person person = new Person();
	PersonService service = new PersonService();
	
	private Person p;
	private String new_password;
	private String comform_password;
	
	
	public PersonService getService() {
		return service;
	}
	public void setService(PersonService service) {
		this.service = service;
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	public String getComform_password() {
		return comform_password;
	}
	public void setComform_password(String comform_password) {
		this.comform_password = comform_password;
	}
	public void validate() {
		
		person = service.FindPersonByName(p.getUsername());
		if(!p.getPassword().equals(person.getPassword())){
			addFieldError("p.password", "请确认密码");
		}
		if(new_password==null || new_password.equals("")){
			addFieldError("new_password", "请输入密码");
		}else if(new_password.length()<6) {
			addFieldError("new_password", "密码位数不能低于6位");
		}
		if(comform_password==null || comform_password.equals("")){
			addFieldError("comform_password", "请确认密码");
		}else if(!comform_password.equals(new_password)){
			addFieldError("comform_password", "请再次确认密码");
		}else{
			Boolean val = service.changePwd(p.getUsername(), new_password);
			if(val==true){
				System.out.println("修改密码成功");
			}else{
				System.out.println("修改密码失败");
			}
		}
		
	}
	
	@Override
	public String execute(){
		ActionContext context = ActionContext.getContext();
		context.getSession().put("username", p.getUsername());
		context.getSession().put("password", p.getPassword());
		return SUCCESS;
	}
}
