package com.example.SpringBoot2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SpringBoot2.exception.ResourceNotFoundException;
import com.example.SpringBoot2.model.Book;
import com.example.SpringBoot2.repo.BookRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookstore")
public class BookController {
	
	@Autowired
	private BookRepo bookRepo;
	
	// get all books (GET METHOD)
	@GetMapping("/books")
	public List<Book> getAllEmployees(){
		return bookRepo.findAll();
	}
	
	// insert book (POST METHOD)
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return bookRepo.save(book);
	}
	
	//delete book (DELETE METHOD)
	@DeleteMapping("/books/{id}")
	public List<Book> deleteBook(@PathVariable long id){
		bookRepo.deleteById(id);
		return (List<Book>)bookRepo.findAll();
	}
	
	// get book by id (GET METHOD)
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		Book book = bookRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not exist with id :" + id));
		return ResponseEntity.ok(book);
	}
	
	
	// update book details (PUT METHOD)
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateEmployee(@PathVariable Long id, @RequestBody Book bookDetails){
		Book book = bookRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not exist with id :" + id));
		
		book.setIsbn(bookDetails.getIsbn());
		book.setTitle(bookDetails.getTitle());
		book.setAuthors(bookDetails.getAuthors());
		book.setYear(bookDetails.getYear());
		book.setPrice(bookDetails.getPrice());

		Book updatedBook = bookRepo.save(book);
		return ResponseEntity.ok(updatedBook);
	}
	
	//find title
	@GetMapping("/books/find/{keyword}")
	public List<Book> findBook(@PathVariable String keyword){
		return bookRepo.findByTitle(keyword);
	}
	
	
}

