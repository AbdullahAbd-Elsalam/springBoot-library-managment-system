package com.maids.cc.library_system.dao;

import com.maids.cc.library_system.model.Patron;

import java.util.List;

public interface PatronDao {

   List<Patron> findAll();
   Patron findById(int id);
   void add(Patron patron);
   void update(int id);
   void delete(int id);

}
