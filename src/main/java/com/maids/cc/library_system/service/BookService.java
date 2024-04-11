package com.maids.cc.library_system.service;

import com.maids.cc.library_system.Exception.BookNotFoundError;
import com.maids.cc.library_system.Exception.TypeNotMatchException;
import com.maids.cc.library_system.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll() throws BookNotFoundError;
    Book findById(int id) throws TypeNotMatchException;
    Book add(Book book) throws BookNotFoundError;
    Book update(int id);
    void delete(int id);
}
