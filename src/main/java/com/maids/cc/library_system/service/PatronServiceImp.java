package com.maids.cc.library_system.service;

import com.maids.cc.library_system.dao.PatronDao;
import com.maids.cc.library_system.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatronServiceImp implements PatronService {

    @Autowired
    PatronDao patronDao;
    @Override
    public List<Patron> findAll() {
      List<Patron> patrons= patronDao.findAll();
      return patrons;
    }

    @Override
    public Patron findById(int id) {
        Patron patron=  patronDao.findById(id);

        return patron;
    }

    @Override
    @Transactional
    public Patron add(Patron patron) {
     patronDao.add(patron);
        return patron;
    }

    @Override
    @Transactional
    public Patron update(int id) {
      patronDao.update(id);
        return null;
    }

    @Override
    @Transactional
    public void delete(int id) {
      patronDao.delete(id);
    }
}
