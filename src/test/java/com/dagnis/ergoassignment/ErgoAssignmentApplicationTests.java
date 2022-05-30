package com.dagnis.ergoassignment;

import com.dagnis.ergoassignment.model.Gender;
import com.dagnis.ergoassignment.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class ErgoAssignmentApplicationTests {

    @Autowired
    PersonController personController;

    @Autowired
    PersonRepository personRepository;

    @Test
    void shouldFindPerson() {
        LocalDate dobFromDb = LocalDate.parse("1924-06-06");
        String personalId = "52191485777";
        String firstName = "Jane";
        String lastName = "Doe";
        Gender gender = Gender.FEMALE;
        String dobFromParam = "1924-06-06";

        Person person = new Person(personalId, firstName, lastName, dobFromDb, gender);
        personRepository.save(person);

        Person personToFind = personController.findByIdAndDob(personalId, dobFromParam);
        Assertions.assertEquals(person, personToFind);
        personRepository.delete(person);
    }

    @Test
    void shouldNotFindPersonWithNonExistentID() {
        LocalDate dobFromDb = LocalDate.parse("1924-03-03");
        Assertions.assertFalse(personRepository.findPersonByPersonalIdAndDateOfBirth("12345678900", dobFromDb).isPresent());
    }

}
