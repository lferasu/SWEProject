package eShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eShop.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
<<<<<<< HEAD
	public List<Book> findAllByIsbnContainsOrTitleContainsOrAuthorsContainsOrCategoriesContainsOrSupplierContainsOrderByTitle(String isbn, String title, String author, String category, String supplier);
=======
	public List<Book> findBookByIsbn(String isbn);
	public List<Book> findAllByTitleContainsOrDescriptionContainsOrIsbnContains(String title, String desc, String isbn);

>>>>>>> b5428b0aaceb565e0964e1283c4dfdcd997726c3
}
