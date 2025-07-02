package com.example;

import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookService bookService) {
        return (args) -> {
            bookService.saveBook(new Book("Spring in Action", "Craig Walls"));
            bookService.saveBook(new Book("Hibernate Tips", "Thorben Janssen"));
            System.out.println("All books:");
            bookService.getAllBooks().forEach(book ->
                System.out.println(book.getId() + ": " + book.getTitle() + " by " + book.getAuthor())
            );
        };
    }
} 