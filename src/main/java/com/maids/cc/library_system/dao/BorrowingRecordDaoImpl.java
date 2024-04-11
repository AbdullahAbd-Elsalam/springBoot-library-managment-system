package com.maids.cc.library_system.dao;

import com.maids.cc.library_system.model.Book;
import com.maids.cc.library_system.model.BorrowingRecord;
import com.maids.cc.library_system.model.Patron;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public class BorrowingRecordDaoImpl implements BorrowingRecordDao{

    @Autowired
    private EntityManager entityManager;

    @Override
       public void borrowBook(int bookId, int patronId) {

        Book book = entityManager.find(Book.class, bookId);
        Patron patron = entityManager.find(Patron.class, patronId);

        if (book != null && patron != null) {
            BorrowingRecord borrowingRecord = new BorrowingRecord();
            borrowingRecord.setBook(book);
            borrowingRecord.setPatron(patron);
            borrowingRecord.setBorrowingDate(LocalDate.now());
            entityManager.persist(borrowingRecord);
        } else {
            throw new IllegalArgumentException("Book or patron not found");
        }
    }

    @Override
      public void returnBook(int bookId, int patronId) {
        BorrowingRecord borrowingRecord = entityManager.createQuery(
                "SELECT br FROM BorrowingRecord br WHERE br.book.id = :bookId AND br.patron.id = :patronId AND br.returnDate IS NULL",
                BorrowingRecord.class)
                .setParameter("bookId", bookId)
                .setParameter("patronId", patronId)
                .getSingleResult();

        if (borrowingRecord != null) {
            borrowingRecord.setReturnDate(LocalDate.now());
            entityManager.merge(borrowingRecord);
        } else {
            throw new IllegalArgumentException("Borrowing record not found or book already returned");
        }
    }
}
