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


        return bookRepository.findAll();

    }
    @Override
    public Page<Book> getAllBooksPaged(int pageNo) {
        return null;
    }

    @Override
    public Book saveBook(Book book) {
       return bookRepository.save(book);
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
        return bookRepository.findAllByIsbnContainsOrTitleContainsOrderByTitle(searchString, searchString);

    }
    public double calculateTotalPrice(Book book){
        double price = 0.0;
//        for(Book book: books){
//            double tax = book.getPrice()*0.01;
//            double deliveryCost = book.getPrice()*0.1;
//            price += book.getPrice() + tax + deliveryCost;
//        }
        double tax = book.getPrice()*0.01;
            double deliveryCost = book.getPrice()*0.1;
            price += book.getPrice() + tax + deliveryCost;
        return price;
    }


//	@Override
//	public Page<Book> getSearchedBooks(int pageNo, Book book) {
//
//		return null;
//	}

}
