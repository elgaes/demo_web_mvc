package haibang.demo.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import haibang.demo.jpa.Person;
/**
 * This simple interface enable Spring data engine to wire in standard
 * JPA query on Person data without us have to write boilerplate codes
 * 
 * @author 		Haibang Mai
 * @version    1.0
 * 
 */
@Repository
public interface PersonRepository extends JpaRepository<Person,String>
{
	public List<Person> findAll();
}
