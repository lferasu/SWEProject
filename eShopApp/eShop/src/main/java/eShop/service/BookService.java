package eShop.service;

import org.springframework.data.domain.Page;

import eShop.model.Book;

public interface BookService {
	
	 	public abstract Iterable<Book> getAllBooks();
	    public abstract Page<Book> getAllBooksPaged(int pageNo);
	    public abstract Book saveBook(Book book);
	    public abstract Book getBookById(Integer bookId);
	    public abstract void deleteBookById(Integer bookId);
	    public abstract Page<Book> getSearchedBooks(int pageNo, Book book);

}
