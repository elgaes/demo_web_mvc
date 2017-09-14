package haibang.demo.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import haibang.demo.jpa.Person;
import haibang.demo.spring.dao.PersonRepository;
/**
 * This simple serivce class intent to provide all Person related infomation 
 * management. It access backend data access layer and provide other logical functions.
 * It should return an intermediate business model object and mapping back end forth between
 * backend model and business model. However this is a simple app with read only let cut the 
 * middleman off.
 * 
 * 
 * @author 		Haibang Mai
 * @version    1.0
 * 
 */

@Service
public class PersonInfoService
{
	protected PersonRepository personRepository;
	
	public PersonRepository getPersonRepository()
	{
		return personRepository;
	}
	
	@Autowired 
	public void setPersonRepository(PersonRepository personRepository)
	{
		this.personRepository = personRepository;
	}
	
	/**
	 * This method query the Person repository all the person and return a list
	 * of person available. 
	 * 
	 * @return      List of Person from backend, if nothing found return empty list
	 * 
	 */

	public List<Person> getAllPersons()
	{	
		List<Person> result=personRepository.findAll();
		//if nothing found return empty list to avoid null pointer.
		return result==null? new ArrayList<Person>() : result;
	}
}
