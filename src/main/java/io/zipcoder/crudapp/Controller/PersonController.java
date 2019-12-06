package io.zipcoder.crudapp.Controller;

import io.zipcoder.crudapp.Model.Person;
import io.zipcoder.crudapp.Services.PersonServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PersonController {

    private PersonServices service;

    public PersonController(PersonServices service){
        this.service = service;
    }

    @PostMapping("/people")
    public ResponseEntity<Person>create(@Valid @RequestBody Person person){
        return new ResponseEntity<Person>(service.create(person), HttpStatus.CREATED);
    }

    @GetMapping("/people/{id}")
    public @ResponseBody ResponseEntity<Person> getPerson(@PathVariable Long id){
        return new ResponseEntity<>(service.getPerson(id), HttpStatus.OK);
    }

    @PutMapping("/people")
    public ResponseEntity<Person> updatePerson(Long id, Person person){
        return new ResponseEntity<>(service.update(id, person), HttpStatus.OK);
    }

    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getPersonList(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}
