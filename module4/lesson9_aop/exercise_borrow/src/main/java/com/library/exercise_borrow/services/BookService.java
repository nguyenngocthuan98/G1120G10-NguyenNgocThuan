package com.library.exercise_borrow.services;

import com.library.exercise_borrow.models.Book;
import com.library.exercise_borrow.services.exception.ZeroQuantityException;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(int id);

    void borrow(Book book) throws ZeroQuantityException;

    void pay(Book book);

    boolean findBookId(int id);
}
