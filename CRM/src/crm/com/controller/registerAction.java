package crm.com.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import crm.com.dao.PersonDao;
import crm.com.model.Person;
import crm.com.service.PersonService;

public class registerAction extends ActionSupport{
	
	Person person = new Person();
	PersonService service = new PersonService();
	
	public PersonService getService() {
		return service;
	}
	public void setService(PersonService service) {
		this.service = service;
	}
	private Person p;
	
	String isEmail = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	
	public void validate() {
		if(p.getUsername()==null || p.getUsername().equals("")){
			addFieldError("p.username", "用户名不能为空");
		}else if(p.getUsername().length()<6 && p.getUsername().length()>20){
			addFieldError("p.username", "用户名长度必须在6-20位之间");
		}else{
			
			person = service.FindPersonByName(p.getUsername());
			if(person != null){
				addFieldError("p.username", "该用户名已被注册");
			}
		}
		if(p.getPassword()==null || p.getPassword().equals("")){
			addFieldError("p.password", "请输入密码");
		}else if(p.getPassword().length()<6) {
			addFieldError("p.password", "密码位数不能低于6位");
		}
		if(p.getConfirmPassword()==null || p.getConfirmPassword().equals("")){
			addFieldError("p.confirmPassword", "请确认密码");
		}else if(!p.getConfirmPassword().equals(p.getPassword())){
			addFieldError("p.confirmPassword", "请再次确认密码");
		}
		if(p.getEmail()==null || p.getEmail().equals("")){
			addFieldError("p.email", "邮箱不能为空");
		}else if(!p.getEmail().matches(isEmail)){
			addFieldError("p.email", "邮箱格式不正确");
		}
	}
	@Override
	public String execute() throws Exception {
		
		/*Person person = new Person();
		person.setUsername(p.getUsername());
		person.setPassword(p.getPassword());
		person.setEmail(p.getEmail());*/
		Boolean val = service.register(p);
		if(val==true){
			System.out.println("注册成功");
		}else{
			System.out.println("注册失败");
		}
		ActionContext context = ActionContext.getContext();
		context.getSession().put("username", p.getUsername());
		context.getSession().put("email", p.getEmail());
		return SUCCESS;
	}
}
