package fr.mns.java.rest.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.mns.java.rest.model.Person;


//@Repository
//@RepositoryRestResource(collectionResourceRel = "persons", path = "persons")
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	
	
	 @EntityGraph(value="Person.address",type = EntityGraphType.LOAD)
     Person findOneWithAddressById(@Param("id") Long id);
	 
	 @EntityGraph(value="Person.address")
	 Person findOneWithAddressByLastName(@Param("name") String name);

	
	
	@Query("select p from Person p left join fetch p.address where p.id =:id")
	Person findOneWithAddressByIdJpql(@Param("id") Long id);
}




//Person findByFirstName(String firstname);