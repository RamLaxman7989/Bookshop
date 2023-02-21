package com.angular.spring.bookshop.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.spring.bookshop.exception.ResourceNotFoundException;
import com.angular.spring.bookshop.model.Bookshop;
import com.angular.spring.bookshop.repository.BookshopRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:57428")
public class BookshopController {
	
	@Autowired
	private BookshopRepository bookshopRepository;
	
	// get all books rest api
	@GetMapping("/bookshop")
	public List<Bookshop> getAllFootballPlayers(){
		return bookshopRepository.findAll();
	}
	
	//add book rest api
	@PostMapping("/bookshop")
	public Bookshop createFootballPlayer(@RequestBody Bookshop bookshop) {
		return bookshopRepository.save(bookshop);
	}
	
	//get book by id rest api
	@GetMapping("/bookshop/{id}")
	public ResponseEntity<Bookshop> updateBookshopById(@PathVariable Long id){
		Bookshop bookshop= bookshopRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Bookshop book not exist with id:" +id));
		return ResponseEntity.ok(bookshop);
	}
	
	//update Bookshop rest Api
	@PutMapping("/bookshop/{id}")
	public ResponseEntity<Bookshop> updateBookshopById(@PathVariable Long id, @RequestBody Bookshop bookshopDetails){
		Bookshop bookshop = bookshopRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Bookshop book not exist with id:" +id));
		

		bookshop.setBookName(bookshopDetails.getBookName());
		bookshop.setBookAuthor(bookshopDetails.getBookAuthor());
		bookshop.setBookPrice(bookshopDetails.getBookPrice());
		bookshop.setBookRating(bookshopDetails.getBookRating());
		
		Bookshop updatedBookshop = bookshopRepository.save(bookshop);
		return ResponseEntity.ok(updatedBookshop);
	}
	

	// delete bookshop rest api
	@DeleteMapping("/bookshop/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBookshop(@PathVariable Long id){
		Bookshop bookshop = bookshopRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Bookshop book not exist with id:" +id));
		
		bookshopRepository.delete(bookshop);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
