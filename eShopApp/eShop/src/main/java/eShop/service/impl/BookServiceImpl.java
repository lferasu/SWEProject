package eShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import eShop.model.Book;
import eShop.repository.BookRepository;
import eShop.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
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


}
