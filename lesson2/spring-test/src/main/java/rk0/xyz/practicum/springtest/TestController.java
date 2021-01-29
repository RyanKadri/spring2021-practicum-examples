package rk0.xyz.practicum.springtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    private final List<Person> people = new ArrayList<>();

    @GetMapping("/people/{id}")
    public Person sayHello(
            @PathVariable int id
    ) {
        for(Person person: people) {
            if(person.id == id) {
                return person;
            }
        }
        return null;
    }

    @GetMapping("/people")
    public List<Person> allNames() {
        return people;
    }

    @PostMapping("/people")
    public String createPerson(@RequestBody Person person) {
        people.add(person);
        return "Success";
    }

}
