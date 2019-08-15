package eShop.repository;
import java.time.LocalDate;
import java.util.List;
import eShop.model.user.Author;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import eShop.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	public List<Book> findAllByIsbnContainsOrTitleContainsOrderByTitle(String isbn, String title, Pageable req);
	List<Book> findAllByPriceEquals(Double price);
	List<Book> findAllByDatePublishedEquals(LocalDate datePublished);

}