package eShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import eShop.model.Book;
import eShop.repository.BookRepository;
import eShop.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
    @Autowired
    private BookRepository repository;

	@Override
	public Iterable<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Book> getAllBooksPaged(int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookById(Integer bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBookById(Integer bookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Book> getSearchedBooks(int pageNo, Book book) {
		// TODO Auto-generated method stub
		return null;
	}

}
