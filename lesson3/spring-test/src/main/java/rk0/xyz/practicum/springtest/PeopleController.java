package rk0.xyz.practicum.springtest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PeopleController {

    private final List<Person> people = new ArrayList<>();

    @GetMapping("/people/{id}")
    public Person sayHello(
            @PathVariable int id
    ) {
        if(id < 0) {
            throw new IllegalArgumentException("Can't have a negative id");
        }
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
    public Person createPerson(@RequestBody Person person) {
        people.add(person);
        return person;
    }

    @DeleteMapping("/people")
    public int getRidOfPeople() {
        int numPeople = people.size();
        people.clear();
        return numPeople;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfo handleException() {
        return new ErrorInfo("Something happened");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo handleIllegalArgument(IllegalArgumentException e) {
        return new ErrorInfo("Illegal argument: " + e.getMessage());
    }
}
