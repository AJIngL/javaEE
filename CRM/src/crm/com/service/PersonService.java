package crm.com.service;

import crm.com.dao.PersonDao;
import crm.com.model.Person;

public class PersonService {
	private PersonDao dao;
	
	public PersonDao getDao() {
		return dao;
	}

	public void setDao(PersonDao dao) {
		this.dao = dao;
	}

	public Boolean register(Person person) {
		return dao.register(person);
	}
	
	public Person login(String userName) {
		return dao.FindName(userName);
	}
	
	public Boolean changePwd(String userName,String newpwd) {
		Boolean val;
		
		val = dao.UpdatePwd(userName, newpwd);
		
		return val;
	}
	
	public Person FindPersonByName(String userName) {
		return dao.FindName(userName);
	}
}
