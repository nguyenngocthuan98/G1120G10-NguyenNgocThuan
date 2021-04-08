package com.library.exercise_borrow.services.impl;

import com.library.exercise_borrow.models.Book;
import com.library.exercise_borrow.repositories.BookRepository;
import com.library.exercise_borrow.services.BookService;
import com.library.exercise_borrow.services.exception.ZeroQuantityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    @Override
    public void borrow(Book book) throws ZeroQuantityException {
        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            this.bookRepository.save(book);
        } else {
            throw new ZeroQuantityException();
        }
    }

    @Override
    public void pay(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        this.bookRepository.save(book);
    }

    @Override
    public boolean findBookId(int id) {
        for (Book book : this.findAll()) {
            if (book.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
