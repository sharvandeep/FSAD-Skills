package com.klu.springmvc;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class Librarycontroller {

    private List<Book> bookList = new ArrayList<>();

    // 1. Welcome Message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    // 2. Total Books
    @GetMapping("/count")
    public int countBooks() {
        return 100;
    }

    // 3. Sample Price
    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    // 4. List of Book Titles
    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Spring Boot", "Java Programming", "Microservices");
    }

    // 5. Get Book by ID
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of Book with ID: " + id;
    }

    // 6. Search by Title
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book titled: " + title;
    }

    // 7. Author Name
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by: " + name;
    }

    // 8. Add Book (POST)
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // 9. View All Books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}
