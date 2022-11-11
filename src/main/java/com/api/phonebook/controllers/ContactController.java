package com.api.phonebook.controllers;

import com.api.phonebook.models.PhoneBook;
import com.api.phonebook.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private PhoneBookService phoneBookService;

    @GetMapping
    public ResponseEntity<List<PhoneBook>> findAll() {
        return new ResponseEntity<>(phoneBookService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PhoneBook> create(@RequestBody PhoneBook phoneBook) {
        return new ResponseEntity<>(phoneBookService.create(phoneBook), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePhoneBook(@PathVariable(value = "id") long id){
        Optional<PhoneBook> phoneBookOptional = phoneBookService.findById(id);
        if (!phoneBookOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(phoneBookOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePhoneBook(@PathVariable(value = "id") long id){
        Optional<PhoneBook> phoneBookOptional = phoneBookService.findById(id);
        if (!phoneBookOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found!");
        }
        phoneBookService.delete(phoneBookOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Contact deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePhoneBook(@PathVariable(value = "id") long id){
        Optional<PhoneBook> phoneBookOptional = phoneBookService.findById(id);
        if (!phoneBookOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found!");
        }
        var phoneBook = phoneBookOptional.get();
        phoneBook.setPhoneNumber(phoneBook.getPhoneNumber());
        return ResponseEntity.status(HttpStatus.OK).body(phoneBookService.save(phoneBook));
    }

}
