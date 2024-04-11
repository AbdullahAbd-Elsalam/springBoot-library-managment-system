use library_system;
CREATE TABLE Book (
                      id int AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      author VARCHAR(255) NOT NULL,
                      publicationYear INT,
                      isbn VARCHAR(20) NOT NULL
);

CREATE TABLE Patron (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        contactInformation VARCHAR(255)
);

CREATE TABLE BorrowingRecord (
                                 id  INT AUTO_INCREMENT PRIMARY KEY,
                                 book_id INT,
                                 patron_id INT,
                                 borrowingDate DATE,
                                 returnDate DATE,
                                 FOREIGN KEY (book_id) REFERENCES Book(id),
                                 FOREIGN KEY (patron_id) REFERENCES Patron(id)
);
