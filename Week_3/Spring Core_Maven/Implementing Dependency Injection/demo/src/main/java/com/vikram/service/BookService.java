package com.vikram.service;

import com.vikram.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookTitle) {
        if (bookRepository != null) {
            bookRepository.save(bookTitle);
            System.out.println("Book '" + bookTitle + "' added successfully.");
        } else {
            System.out.println("BookRepository is not initialized.");
        }
    }
}