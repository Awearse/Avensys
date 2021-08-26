package com.example.SpringBoot2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SpringBoot2.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{
	
	List<Book> findByTitle(String title);
	
	List<Book> findByAuthors(String authors);

}
