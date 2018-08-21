package crm.com.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import crm.com.model.Person;


public class PersonDao {
	private HibernateTemplate template;
	public HibernateTemplate getTemplate() {
		return template;
	}
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	public boolean register(Person person) {
		boolean val = false;
		
		try {
			template.save(person);
			val = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
		
	}
	public Person FindName(String userName){
		Person person = new Person();
		
		String HQL = "from Person where username=?";
		
		
		return template.find(HQL, userName).size() != 0?(Person)template.find(HQL, userName).get(0):null;
		
		//return person;
	}
	public Boolean UpdatePwd(String username,String newpwd){
		Boolean val = false;
		
		Person person = template.get(Person.class, FindName(username).getUserId());
		person.setPassword(newpwd);
		
		try {
			template.update(person);
			val = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return val;
	}

}
