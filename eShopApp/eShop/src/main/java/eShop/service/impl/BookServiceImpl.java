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
<<<<<<< HEAD
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
	public List<Book> getAllBooksQuickSearch(String searchString) {
return repository.findAllByIsbnContainsOrTitleContainsOrAuthorsContainsOrCategoriesContainsOrSupplierContainsOrderByTitle(searchString,searchString,searchString,searchString,searchString);
	}
=======
    private BookRepository bookRepository;

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll(Sort.by("title"));
    }

    @Override
    public Page<Book> getAllBooksPaged(int pageNo) {
        return bookRepository.findAll(PageRequest.of(pageNo, 5, Sort.by("title")));
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Integer bookId) {
        return bookRepository.getOne(bookId);
    }

    @Override
    public void deleteBookById(Integer bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Page<Book> getQuickSearchBooks(int pageNo, String searchText) {
        List<Book> foundBooks = bookRepository.findAllByTitleContainsOrDescriptionContainsOrIsbnContains(searchText,searchText,searchText);
        return new PageImpl<Book>(foundBooks,PageRequest.of(pageNo, 4, Sort.by("title")), foundBooks.size());
    }

>>>>>>> b5428b0aaceb565e0964e1283c4dfdcd997726c3

//	@Override
//	public Page<Book> getSearchedBooks(int pageNo, Book book) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
