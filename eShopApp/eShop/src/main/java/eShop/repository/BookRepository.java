package eShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eShop.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	public List<Book> findBookByIsbn(String isbn);
	//public List<Book> findAllByTitleContainsAndIsbnContainsAndPublisherContains(String title, String Isbn, String author);

}
