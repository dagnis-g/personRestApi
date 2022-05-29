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
        String dobFromParam = "1924-03-03";
        String personalId = "52191485762";

        LocalDate dobFromDb = LocalDate.parse("1924-03-03");
        String firstName = "Eloise";
        String lastName = "Swetenham";
        Gender gender = Gender.FEMALE;

        Person personToFind = personController.findByIdAndDob(personalId, dobFromParam);
        Person personExpected = new Person(personalId, firstName, lastName, dobFromDb, gender);

        Assertions.assertEquals(personExpected, personToFind);
    }

    @Test
    void shouldNotFindPersonWithNonExistentID() {
        LocalDate dobFromDb = LocalDate.parse("1924-03-03");
        Assertions.assertNull(personRepository.findPersonByPersonalIdAndDateOfBirth("12345678900", dobFromDb));
    }

}
