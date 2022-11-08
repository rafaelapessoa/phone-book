package com.api.phonebook.repositories;

import com.api.phonebook.models.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBook, Long> {

    Optional<PhoneBook> findById(long id);
}
