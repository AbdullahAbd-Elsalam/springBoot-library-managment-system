package com.maids.cc.library_system.dao;

import com.maids.cc.library_system.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDaoImp implements BookDao{

    // define entity manager to manipulate data with database
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Book> findAll() {


        // make aquery to retrive all books
        TypedQuery<Book> books=entityManager.createQuery("From Book ",Book.class);
        return books.getResultList();
    }

    @Override
    public Book findById(int id) {
        Book book=  entityManager.find(Book.class,id);

        return book;
    }

    @Override
    @Transactional
    public Book add(Book book) {
          entityManager.persist(book);
          return book;
    }

    @Override
      public Book update(int id) {
       // get object by id
        Book book=entityManager.find(Book.class,id);
        entityManager.merge(book);
        return book;
    }

    @Override
     public void delete(int id) {
        // get object by id
        Book book=entityManager.find(Book.class,id);
        entityManager.remove(book);
    }
}
