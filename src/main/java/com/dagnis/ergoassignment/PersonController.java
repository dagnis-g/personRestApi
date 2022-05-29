package com.dagnis.ergoassignment;

import com.dagnis.ergoassignment.model.Person;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/find")
    public Person findByIdAndDob(@RequestParam String personalId, @RequestParam String dateOfBirth) {
        return personService.findPersonByIdAndDob(personalId, dateOfBirth);
    }
    
}
