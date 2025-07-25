package org.example.library_management.service;

import org.example.library_management.entity.Book;
import org.example.library_management.entity.BorrowCode;
import org.example.library_management.repository.IBookRepository;
import org.example.library_management.repository.IBorrowCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IBorrowCodeRepository borrowCodeRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    
    @Override
    public BorrowCode borrowBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.getQuantity() == 0) {
            throw new RuntimeException("Book out of stock");
        }
        book.setQuantity(book.getQuantity() - 1);
        
        BorrowCode code = new BorrowCode();
        code.setCode(generateCode());
        
        code.setBook(book);
        bookRepository.save(book);
        return borrowCodeRepository.save(code);
    }

    @Override
    public void returnBook(String codeStr) {
        BorrowCode code = borrowCodeRepository.findByCode(codeStr)
                .orElseThrow(()-> new RuntimeException("Invalid borrow code"));
        Book book = code.getBook();
        book.setQuantity(book.getQuantity()+1);
        borrowCodeRepository.delete(code);
        bookRepository.save(book);
    }

    private String generateCode() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }
}
