package com.dagnis.ergoassignment;

import com.dagnis.ergoassignment.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
class PersonServiceTest {

    @Autowired
    PersonService personService;

    @Test
    @ExtendWith(OutputCaptureExtension.class)
    void shouldThrowOnInvalidId() {
        ResponseStatusException thrown = Assertions.assertThrows(ResponseStatusException.class, () -> {
            personService.findPersonByIdAndDob("12344", "1924-03-03");
        });
        Assertions.assertEquals("400 BAD_REQUEST \"Invalid personal ID\"", thrown.getMessage());
    }

    @Test
    void shouldThrowOnNoPersonFound() {
        ResponseStatusException thrown = Assertions.assertThrows(ResponseStatusException.class, () -> {
            personService.findPersonByIdAndDob("12345678900", "1924-03-03");
        });
        Assertions.assertEquals("400 BAD_REQUEST \"No such person found\"", thrown.getMessage());
    }

    @Test
    void shouldLogInfoOnFound(CapturedOutput output) {
        Person person = personService.findPersonByIdAndDob("52191485762", "1924-03-03");
        String expectedMessage = "Found person: " + person;
        Assertions.assertTrue(output.toString().contains(expectedMessage));
    }

}