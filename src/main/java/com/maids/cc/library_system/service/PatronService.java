package com.maids.cc.library_system.service;

import com.maids.cc.library_system.model.Patron;

import java.util.List;

public interface PatronService {

   List<Patron> findAll();
   Patron findById(int id);
   Patron add(Patron patron);
   Patron update(int id);
   void delete(int id);

}
