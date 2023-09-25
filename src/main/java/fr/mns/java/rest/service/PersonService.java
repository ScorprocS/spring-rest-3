package fr.mns.java.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fr.mns.java.rest.model.Gender;
import fr.mns.java.rest.model.Person;
import fr.mns.java.rest.repository.PersonRepository;



@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;	
	
	public List<Person> findAll(){
		return personRepository.findAll();
	}
	//
	public Person findById(Long id) {
		return personRepository.findById(id).orElse(null);
	}
	
	public Iterable<Person> findAllFirst20(){
		//page:0 taille: 20
		return personRepository.findAll(PageRequest.of(0, 20,Sort.by("lastName")));
	}
	
	public Page<Person> findAll(Integer pageNumber,Integer pageSize){
		return personRepository.findAll(PageRequest.of(pageNumber, pageSize));
	}
	
	
	
	public void deleteById(Long id) {
	    personRepository.deleteById(id);
	}
	
	
	public Person save(Person p){
		return personRepository.save(p);
	}
	
	
	public Iterable<Person> findAllByExampleOlivier(){
		Person person=new Person();
		person.setFirstName("Olivier");
		person.setGender(Gender.MALE);
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnoreCase()
				.withIgnoreNullValues();
		Example<Person> personExample= Example.of(person,matcher);
		
		return personRepository.findAll(personExample);		
	}
	
}

