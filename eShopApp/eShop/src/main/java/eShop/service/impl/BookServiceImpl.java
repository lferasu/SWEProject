package eShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import eShop.model.Book;
import eShop.repository.BookRepository;
import eShop.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Iterable<Book> getAllBooks() {
        return null;
    }
    @Override
    public Page<Book> getAllBooksPaged(int pageNo) {
        return null;
    }

    @Override
    public Book saveBook(Book book) {
        return null;
    }

    @Override
    public Book getBookById(Integer bookId) {
        return null;
    }

    @Override
    public void deleteBookById(Integer bookId) {

    }

    @Override
    public List<Book> getAllBooksQuickSearch(String searchString) {
        return bookRepository.findAllByIsbnContainsOrTitleContainsOrAuthorsContainsOrCategoriesContainsOrSupplierContainsOrderByTitle(searchString,
                searchString,searchString,searchString,searchString);
    }




//	@Override
//	public Page<Book> getSearchedBooks(int pageNo, Book book) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
