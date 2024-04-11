package com.maids.cc.library_system.service;

public interface BorrowingRecordService {

    void borrowBook(int bookId, int patronId);
    void returnBook(int bookId, int patronId);
}
