package com.maids.cc.library_system.dao;

import com.maids.cc.library_system.model.Book;

import java.util.List;

public interface BookDao {

    List<Book> findAll();
    Book findById(int id);
    Book add(Book book);
    Book update(int id);
    void delete(int id);
}
