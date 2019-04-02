package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    //List<Person> personList;

    @Autowired
    PersonRepository personRepository;

    public PersonController(){
        //personList=new ArrayList<>();
    }

    @PostMapping("/persons/")
    public Person createPerson(@RequestBody Person p){
        personRepository.save(p);
        return p;
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable int id){
        Person returnPerson = personRepository.findOne(id);

        return returnPerson;
    }

    @GetMapping("/persons/")
    public List<Person> getPersonList(){
        List<Person> returnPersonList = personRepository.findAll();
        return returnPersonList;
    }

    @PutMapping("/persons/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person p){
        Person dbPerson = personRepository.findOne(id);
        dbPerson.setFirstName(p.getFirstName());
        dbPerson.setLastName(p.getLastName());

        Person updatedPerson= personRepository.save(dbPerson);
        return updatedPerson;
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable int id){
        personRepository.delete(id);
    }
}
