package com.example.demo.controller;

import com.example.demo.model.Person;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @PostMapping
    public String createPerson(@Valid @RequestBody Person person) throws com.example.demo.controller.MyCustomException {
        if ("error".equalsIgnoreCase(person.getName())) {
            throw new com.example.demo.controller.MyCustomException("Invalid person name: " + person.getName());
        }
        return "Person created: " + person.getName();
    }
}
