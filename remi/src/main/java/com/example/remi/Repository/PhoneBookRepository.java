package com.example.remi.Repository;

import com.example.remi.entity.Memo;
import com.example.remi.entity.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneBookRepository extends JpaRepository<PhoneBook, Long> {


}


