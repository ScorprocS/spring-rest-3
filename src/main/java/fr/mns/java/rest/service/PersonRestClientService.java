package fr.mns.java.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mns.java.rest.client.Person;
import fr.mns.java.rest.client.PersonRestClient;

@Service
public class PersonRestClientService {
	@Autowired
	private PersonRestClient personRestClient;
	
	public List<Person> getAll(){
		return personRestClient.getPersons();
	}

}
