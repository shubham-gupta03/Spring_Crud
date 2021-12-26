package com.crud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.model.Book;

public interface BookDao extends JpaRepository<Book, Integer>{

}
