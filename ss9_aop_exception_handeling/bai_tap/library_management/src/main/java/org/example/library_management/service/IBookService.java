package org.example.library_management.service;

import org.example.library_management.entity.Book;
import org.example.library_management.entity.BorrowCode;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Long id);
    BorrowCode borrowBook(Long bookId);
    void returnBook(String codeStr);
    
}
