package fr.mns.java.rest.dto;

import org.springframework.stereotype.Component;

import fr.mns.java.rest.model.Person;


@Component
public class EditPersonRequestToPersonConverter {
	

	public Person convert(Person p,EditPersonRequest request) {
		p.setFirstName(request.getFirstName());
		p.setLastName(request.getLastName());
		p.setPhoneNumber(request.getPhoneNumber());
		p.setGender(request.getGender());
		p.setBirthDate(request.getBirthDate());
		
		return p;

	}
	
	public Person convert(EditPersonRequest request) {
		Person p=new Person();
	
		return convert(p,request);

	}

}
