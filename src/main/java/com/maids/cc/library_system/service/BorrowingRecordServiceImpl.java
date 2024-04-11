package com.maids.cc.library_system.service;

import com.maids.cc.library_system.dao.BorrowingRecordDao;
import com.maids.cc.library_system.model.Book;
import com.maids.cc.library_system.model.BorrowingRecord;
import com.maids.cc.library_system.model.Patron;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
public class BorrowingRecordServiceImpl implements BorrowingRecordService {

    @Autowired
    private BorrowingRecordDao borrowingRecordDao;
    @Override
    @Transactional
    public void borrowBook(int bookId, int patronId) {

    borrowingRecordDao.borrowBook(bookId,patronId);
    }

    @Override
    @Transactional
    public void returnBook(int bookId, int patronId) {
      borrowingRecordDao.returnBook(bookId,patronId);
    }
}
