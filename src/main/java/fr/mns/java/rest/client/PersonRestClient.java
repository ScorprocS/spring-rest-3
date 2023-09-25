package fr.mns.java.rest.client;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(value = "personsClient", url = "http://localhost:8080/api/persons")
public interface PersonRestClient {
	@RequestMapping(method = RequestMethod.GET, value = "")
	List<Person> getPersons();

	@GetMapping(value = "/{personId}", produces = "application/json")
	Person getPersonById(@PathVariable("personId") Long personId);
	
	@PostMapping(value="")
	String createNewPerson(@RequestBody Person person);
	
	@DeleteMapping(value="/{personId}")
	String deletePerson(@PathVariable("personId") Long personId);
	
}

