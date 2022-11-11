package com.api.phonebook.service;

import com.api.phonebook.models.PhoneBook;
import com.api.phonebook.repositories.PhoneBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PhoneBookService {

    @Autowired
    private PhoneBookRepository phoneBookRepository;


    public List<PhoneBook> findAll() {
        List<PhoneBook> phones = phoneBookRepository.findAll();

        for (PhoneBook  p: phones){
            p.setName(p.getName().toUpperCase());
        }
        return phones;
    }
    public PhoneBook create(PhoneBook phoneBook) {
        return phoneBookRepository.save(phoneBook);
    }

    public Optional<PhoneBook> findById(long id) {

        return phoneBookRepository.findById(id);
    }

    public void delete(PhoneBook phoneBook) {
        phoneBookRepository.delete(phoneBook);
    }

    public PhoneBook update(PhoneBook phoneBook) {
        return phoneBookRepository.save(phoneBook);
    }

    public PhoneBook save(PhoneBook phoneBook) {
        return phoneBookRepository.save(phoneBook);
    }
}
