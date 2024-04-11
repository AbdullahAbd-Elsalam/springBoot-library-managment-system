package com.maids.cc.library_system.service;

 import com.maids.cc.library_system.Exception.BookNotFoundError;
 import com.maids.cc.library_system.Exception.TypeNotMatchException;
 import com.maids.cc.library_system.dao.BookDao;
import com.maids.cc.library_system.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServieImp implements BookService {

    // define entity manager to manipulate data with database
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> findAll() throws BookNotFoundError {


        List<Book>  books= bookDao.findAll();
        if(books == null)
            throw new BookNotFoundError("there are no books in library");
         return  books;
    }

    @Override
    public Book findById(int id) throws TypeNotMatchException {

        if(id<=0 || id>5000)
            throw new TypeNotMatchException("id not match ");
       Book book= bookDao.findById(id);



        return book;
    }

    @Override
    @Transactional
    public Book add(Book book) throws BookNotFoundError {
        if(book == null)
            throw new BookNotFoundError("book is null");
        return bookDao.add(book);

     }

    @Override
    @Transactional
    public Book update(int id) {
    Book book=  bookDao.update(id);
     return book;
    }

    @Override
    @Transactional
    public void delete(int id) {
       bookDao.delete(id);
    }
}
