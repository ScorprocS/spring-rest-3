package fr.mns.java.rest.dto;

import java.time.LocalDate;

import fr.mns.java.rest.model.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


public class EditPersonRequest {
	
	@NotBlank(message = "firstName is mandatory")
	private String firstName;
	
	@NotBlank(message = "firstName is mandatory")
	private String lastName;
	
	@Past
	private LocalDate birthDate;
	
	@Size(min = 10,max = 10)
	private String phoneNumber;
	
	@NotNull
	private Gender gender;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
	
}
