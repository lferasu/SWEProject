package eShop.service.impl;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
        return bookRepository.findById(bookId).orElse(null);

    }

    @Override
    public void deleteBookById(Integer bookId) {

    }
    @Override
    public List<Book> getAllBooksQuickSearch(String searchString) {
        if(isMoney(searchString)&&containsDecimalPoint(searchString)){
            return  bookRepository.findAllByPriceEquals(Double.parseDouble(searchString));
        }
        else if(isDate(searchString))
        {
            return  bookRepository.findAllByDatePublishedEquals(LocalDate.parse(searchString,DateTimeFormatter.ISO_DATE));
        }
       else
           return bookRepository.findAllByIsbnContainsOrTitleContainsOrderByTitle(searchString, searchString);
    }
    //==Beginning of getAllBooksQuickSearch(String searchString) helper methods==//
    private boolean isMoney(String searchString) {
        boolean isParseableAsMoney = false;
        try {
            Double.parseDouble(searchString);
            isParseableAsMoney = true;
        } catch (Exception ex) {
            if (ex instanceof ParseException) {
                isParseableAsMoney = false;
            }
        }
        return isParseableAsMoney;
    }
    private boolean isDate(String searchString) {
        boolean isParseableAsDate = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        } catch (Exception ex) {
            if (ex instanceof DateTimeParseException) {
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }
    private boolean containsDecimalPoint(String searchString) {
        return searchString.contains(".");
    }

    public double calculateTotalPrice(List<Book> books){

        double price = 0.0;
        for(Book book: books){
            double tax = book.getPrice()*0.01;
            double deliveryCost = book.getPrice()*0.1;
            price += book.getPrice() + tax + deliveryCost;
        }

        return price;
    }
}