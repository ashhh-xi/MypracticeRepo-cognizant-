package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printBook() {
        if (bookRepository != null) {
            System.out.println("BookService: Book from repository: " + bookRepository.getBook());
        } else {
            System.out.println("BookService: No repository injected!");
        }
    }
} 