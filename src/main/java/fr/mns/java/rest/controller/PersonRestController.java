package fr.mns.java.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.mns.java.rest.dto.EditPersonRequest;
import fr.mns.java.rest.dto.EditPersonRequestToPersonConverter;
import fr.mns.java.rest.exception.InvalidParameterException;
import fr.mns.java.rest.exception.NotFoundException;
import fr.mns.java.rest.model.Person;
import fr.mns.java.rest.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/persons")
public class PersonRestController {
	@Autowired
	private PersonService personService;

	@Autowired
	private EditPersonRequestToPersonConverter personConverter;

	@GetMapping(value = "")
	public ResponseEntity<List<Person>> getAll() {
		return ResponseEntity.ok(personService.findAll());
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Person>> getPage(@RequestParam("pageNumber") Integer pageNumber,
			@RequestParam("pageSize") Integer pageSize) {
		if (pageNumber == null || pageSize == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(personService.findAll(pageNumber, pageSize));
	}

	
	@ApiOperation(value = "createPerson", notes = "create new Person", nickname = "createPerson")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
	@ApiResponse(code = 201, message = "Successful retrieval") })
	@PostMapping("")
	public ResponseEntity<?> createPerson2(@RequestBody @Valid EditPersonRequest request) throws URISyntaxException {
		Person person = personService.save(personConverter.convert(request));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updatePerson(@PathVariable("id") Long id, @RequestBody @Valid EditPersonRequest request)
			throws URISyntaxException {

		Person person = personService.findById(id);
		personService.save(personConverter.convert(person, request));

		return ResponseEntity.ok().build();

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		personService.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	
	/*
	 * @GetMapping(value="/{personId}") public ResponseEntity<Person>
	 * get(@PathVariable("personId") Long personId){ if(personId==null ||
	 * personId<=0) { return ResponseEntity.badRequest().build(); } Person
	 * p=personService.findById(personId); if(p==null) { return
	 * ResponseEntity.notFound().build(); }
	 * 
	 * return ResponseEntity.ok(p); }
	 */

	@GetMapping(value = "/{personId}")
	public ResponseEntity<Person> get(@PathVariable("personId") Long personId)
			throws InvalidParameterException, NotFoundException {
		if (personId == null || personId <= 0) {
			throw new InvalidParameterException("personId");
		}
		Person p = personService.findById(personId);
		if (p == null) {
			throw new NotFoundException(personId);
		}

		return ResponseEntity.ok(p);
	}
}
