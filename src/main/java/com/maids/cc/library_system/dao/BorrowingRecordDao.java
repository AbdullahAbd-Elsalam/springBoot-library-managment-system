package com.maids.cc.library_system.dao;

public interface BorrowingRecordDao {

    void borrowBook(int bookId, int patronId);
    void returnBook(int bookId, int patronId);
}
