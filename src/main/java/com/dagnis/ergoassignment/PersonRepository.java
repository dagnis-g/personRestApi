package com.dagnis.ergoassignment;

import com.dagnis.ergoassignment.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    Optional<Person> findPersonByPersonalIdAndDateOfBirth(String personalId, LocalDate dob);
}
