package com.dagnis.ergoassignment;

import com.dagnis.ergoassignment.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findPersonByIdAndDob(String personalId, String dob) {

        if (!isPersonalIdValid(personalId)) {
            log.warn("PersonalId invalid:" + personalId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid personal ID");
        }

        LocalDate dateOfBirth = LocalDate.parse(dob);
        Optional<Person> person = personRepository.findPersonByPersonalIdAndDateOfBirth(personalId, dateOfBirth);
        if (person.isEmpty()) {
            log.info("not found by" + "ID:" + personalId + " Dob: " + dob);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such person found");
        } else {
            log.info("Found person: " + person.get());
            return person.get();
        }
    }

    private boolean isPersonalIdValid(String id) {
        String personID = id.replaceAll("\\D", "");
        return personID.length() == 11;
    }

}
