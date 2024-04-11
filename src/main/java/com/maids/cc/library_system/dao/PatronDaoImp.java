package com.maids.cc.library_system.dao;

import com.maids.cc.library_system.model.Book;
import com.maids.cc.library_system.model.Patron;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PatronDaoImp implements PatronDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Patron> findAll() {

        // make aquery to retrive all books
        TypedQuery<Patron> patrons=entityManager.createQuery("From Patron ",Patron.class);
        return patrons.getResultList();
    }

    @Override
    public Patron findById(int id) {
        Patron patron=  entityManager.find(Patron.class,id);

        return patron;
    }

    @Override
     public void add(Patron patron) {
     entityManager.persist(patron);
    }

    @Override
      public void update(int id) {
        // get object by id
        Patron patron=entityManager.find(Patron.class,id);
        entityManager.merge(patron);
    }

    @Override
      public void delete(int id) {
        // get object by id
        Patron patron=entityManager.find(Patron.class,id);
        entityManager.remove(patron);
    }
}
