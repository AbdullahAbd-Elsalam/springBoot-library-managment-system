package com.maids.cc.library_system.controller;

import com.maids.cc.library_system.Exception.BookNotFoundError;
import com.maids.cc.library_system.Exception.TypeNotMatchException;
import com.maids.cc.library_system.model.Book;
import com.maids.cc.library_system.model.Patron;
import com.maids.cc.library_system.service.BookService;
import com.maids.cc.library_system.service.BorrowingRecordService;
import com.maids.cc.library_system.service.PatronService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "this is documentaion of rest of Library controller class")
@RequestMapping("/api")
public class LibraryController {


    private  BookService bookService;
    private   PatronService patronService;
    private   BorrowingRecordService borrowingRecordService;

    @Autowired
    public LibraryController(BookService bookService, PatronService patronService, BorrowingRecordService borrowingRecordService) {
        this.bookService = bookService;
        this.patronService = patronService;
        this.borrowingRecordService = borrowingRecordService;
    }


    // Book management endpoints
    @GetMapping("/books")
    @ApiOperation(value = "Retrieve details of a specific book by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved book"),
            @ApiResponse(code = 404, message = "Book not found")
    })
    public ResponseEntity<List<Book>> getAllBooks() throws BookNotFoundError {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) throws TypeNotMatchException {
        Book book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/books")
    @ApiOperation(value = "Add a new book to the library")
    public ResponseEntity<Book> addBook(@RequestBody Book book) throws BookNotFoundError {
        Book savedBook = bookService.add(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/books/{id}")
    @ApiOperation(value = "Update an existing book's information")
    public ResponseEntity<Book> updateBook(@PathVariable int id) {
        Book updatedBook = bookService.update(id);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Patron management endpoints
    @GetMapping("/patrons")
    @ApiOperation(value = "Remove a book from the library")
    public ResponseEntity<List<Patron>> getAllPatrons() {
        List<Patron> patrons = patronService.findAll();
        return ResponseEntity.ok(patrons);
    }

    @GetMapping("/patrons/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable int id) {
        Patron patron = patronService.findById(id);
        return ResponseEntity.ok(patron);
    }

    @PostMapping("/patrons")
    public ResponseEntity<Patron> addPatron(@RequestBody Patron patron) {
        Patron savedPatron = patronService.add(patron);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatron);
    }

    @PutMapping("/patrons/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable int id) {
        Patron updatedPatron = patronService.update(id);
        return ResponseEntity.ok(updatedPatron);
    }

    @DeleteMapping("/patrons/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable int id) {
        patronService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // endpoint
    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    @ApiOperation(value = "Allow a patron to borrow a book")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Book successfully borrowed"),
            @ApiResponse(code = 404, message = "Book or patron not found"),
            @ApiResponse(code = 400, message = "Invalid request parameters")
    })
    public ResponseEntity<String> borrowBook(@PathVariable int bookId, @PathVariable int patronId) {
        borrowingRecordService.borrowBook(bookId, patronId);
        return ResponseEntity.ok("Book borrowed successfully");
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<String> returnBook(@PathVariable int bookId, @PathVariable int patronId) {
        borrowingRecordService.returnBook(bookId, patronId);
        return ResponseEntity.ok("Book returned successfully");
    }
}
