package com.api.phonebook.controllers;

import com.api.phonebook.models.PhoneBook;
import com.api.phonebook.repositories.PhoneBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private PhoneBookRepository phoneBookRepository;

    @GetMapping
    public List<PhoneBook> listar(){
        return phoneBookRepository.findAll();
    }

    @PostMapping
        public PhoneBook adicionar (@RequestBody PhoneBook phoneBook){
        return phoneBookRepository.save(phoneBook);
    }


}
