package in.learnjavaskills.handlebooks.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.learnjavaskills.handlebooks.model.Books;

@RestController
public class BooksController 
{
	private List<Books> booksStorage = new ArrayList<>();
	
	@PostMapping(path = "addBook")
	public Books addBook(@RequestBody Books book)
	{
		booksStorage.add(book);
		return book;
	}
	
	@GetMapping(path = "fetchAllBooks")
	public List<Books> fetchAllBooks()
	{
		return booksStorage;
	}
	
	@DeleteMapping(path = "deleteBookById/{id}")
	public List<Books> deleteBookById(@PathVariable int id)
	{
		/* Imperative style */
//		for(Books book : booksStorage)
//		{
//			if (book.getId() == id)
//				booksStorage.remove(book);
//		}
		
		/* Declarative Style */
		booksStorage.removeIf(book -> book.getId() == id );
		return booksStorage;
	}
	
	@PutMapping(path = "UpdateBookById/{id}")
	public List<Books> updateBookById(@PathVariable int id, @RequestBody Books updateBook)
	{
		/* Imperative style */
//		for(Books book : booksStorage)
//		{
//			if (book.getId() == id)
//			{
//				booksStorage.remove(book);
//				booksStorage.add(updateBook);
//			}
//		}
		
		/* Declarative Style */
		booksStorage.removeIf(book -> book.getId() == id );
		booksStorage.add(updateBook);
		return booksStorage;		
	}
}
