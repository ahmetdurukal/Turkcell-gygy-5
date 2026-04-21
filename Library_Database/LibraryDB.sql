--LibraryDB
CREATE TABLE Student (
    StudentID SERIAL PRIMARY KEY,
    StudentNo VARCHAR(20) UNIQUE NOT NULL,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100),
    Phone VARCHAR(20)
);

CREATE TABLE Staff (
    StaffID SERIAL PRIMARY KEY,
    EmployeeNo VARCHAR(20) UNIQUE NOT NULL,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Shift VARCHAR(20),
    Contact VARCHAR(50)
);

CREATE TABLE Book (
    BookID SERIAL PRIMARY KEY,
    ISBN VARCHAR(20) UNIQUE NOT NULL,
    Title VARCHAR(150) NOT NULL,
    Author VARCHAR(100) NOT NULL,
    Status VARCHAR(20) DEFAULT 'Mevcut'
);

CREATE TABLE Transaction (
    TransactionID SERIAL PRIMARY KEY,
    BookID INT NOT NULL,
    StudentID INT NOT NULL,
    StaffID INT NOT NULL,
    BorrowDate DATE NOT NULL,
    DueDate DATE NOT NULL,
    ReturnDate DATE,
    Status VARCHAR(20) DEFAULT 'Ödünç Verildi',
    FOREIGN KEY (BookID) REFERENCES Book(BookID),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
    FOREIGN KEY (StaffID) REFERENCES Staff(StaffID)
);

CREATE TABLE Fine (
    FineID SERIAL PRIMARY KEY,
    TransactionID INT NOT NULL,
    StudentID INT NOT NULL,
    Reason VARCHAR(100),
    Amount DECIMAL(10, 2) NOT NULL,
    PaymentStatus VARCHAR(20) DEFAULT 'Ödenmedi',
    FOREIGN KEY (TransactionID) REFERENCES Transaction(TransactionID),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
);

INSERT INTO Student (StudentNo, FirstName, LastName, Email, Phone) VALUES
('2024001', 'Ahmet', 'Yılmaz', 'ahmet.yilmaz@email.com', '05051112233'),
('2024002', 'Mehmet', 'Demir', 'mehmet.demir@email.com', '05052223344'),
('2024003', 'Ayşe', 'Kaya', 'ayse.kaya@email.com', '05053334455'),
('2024004', 'Fatma', 'Çelik', 'fatma.celik@email.com', '05054445566'),
('2024005', 'Can', 'Öztürk', 'can.ozturk@email.com', '05055556677');

INSERT INTO Staff (EmployeeNo, FirstName, LastName, Shift, Contact) VALUES
('G001', 'Süleyman', 'Soylu', 'Sabah', 'Dahili: 101'),
('G002', 'Emel', 'Sayın', 'Öğle', 'Dahili: 102'),
('G003', 'Kemal', 'Sunal', 'Akşam', 'Dahili: 103'),
('G004', 'Adile', 'Naşit', 'Sabah', 'Dahili: 104'),
('G005', 'Tarık', 'Akan', 'Öğle', 'Dahili: 105');

INSERT INTO Book (ISBN, Title, Author, Status) VALUES
('9786053755', 'İnce Memed', 'Yaşar Kemal', 'Mevcut'),
('9789750719', 'Tutunamayanlar', 'Oğuz Atay', 'Ödünç Verildi'),
('9789750802', 'Kürk Mantolu Madonna', 'Sabahattin Ali', 'Mevcut'),
('9789754582', 'Çalıkuşu', 'Reşat Nuri Güntekin', 'Mevcut'),
('9786053321', 'Saatleri Ayarlama Enstitüsü', 'Ahmet Hamdi Tanpınar', 'Ödünç Verildi');

INSERT INTO Transaction (BookID, StudentID, StaffID, BorrowDate, DueDate, ReturnDate, Status) VALUES
(2, 1, 1, '2026-04-10', '2026-04-24', NULL, 'Ödünç Verildi'),
(5, 3, 2, '2026-04-12', '2026-04-26', NULL, 'Ödünç Verildi'),
(1, 2, 3, '2026-03-01', '2026-03-15', '2026-03-14', 'İade Edildi'),
(3, 4, 4, '2026-03-05', '2026-03-19', '2026-03-25', 'Gecikmiş İade'),
(4, 5, 5, '2026-04-01', '2026-04-15', '2026-04-15', 'İade Edildi');

INSERT INTO Fine (TransactionID, StudentID, Reason, Amount, PaymentStatus) VALUES
(4, 4, 'Gecikme Cezası', 45.50, 'Ödenmedi'),
(1, 1, 'Kitap Sayfa Hasarı', 20.00, 'Ödendi'),
(2, 3, 'Gecikme Cezası', 15.00, 'Ödenmedi'),
(3, 2, 'Üyelik Kartı Yenileme', 10.00, 'Ödendi'),
(5, 5, 'Gecikme Cezası', 5.00, 'Ödenmedi');

SELECT * FROM Student;

ALTER TABLE Student ALTER COLUMN Phone TYPE VARCHAR(11); 

ALTER TABLE Student ADD CONSTRAINT chk_student_email CHECK (Email LIKE '%@%');

ALTER TABLE Staff RENAME COLUMN Shift TO WorkShift;

ALTER TABLE Book ADD COLUMN Category VARCHAR(30);

SELECT * FROM BOOK;

UPDATE Book 
SET Category = 'Roman' 
WHERE Title = 'İnce Memed';

UPDATE Book 
SET Category = 'Roman' 
WHERE Title = 'Tutunamayanlar';

UPDATE Book 
SET Category = 'Klasik' 
WHERE Title = 'Kürk Mantolu Madonna';

UPDATE Book 
SET Category = 'Klasik' 
WHERE Title = 'Çalıkuşu';

UPDATE Book 
SET Category = 'Tarih-Kurgu' 
WHERE Title = 'Saatleri Ayarlama Enstitüsü';

SELECT Title, Author, Category FROM Book;

SELECT * FROM STAFF; 
