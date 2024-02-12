package kea.exercise.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kea.exercise.person.model.Person;

public interface PersonRepository extends JpaRepository<Person,Integer> {

}
