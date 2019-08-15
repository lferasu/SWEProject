package eShop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import eShop.model.user.Author;
import eShop.model.user.User;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Book {

	@Id@GeneratedValue
	private Integer id;
	private String title;
	private String description;
	private String isbn;
	private Double price;
	private Integer numberOfCopies;
	private Boolean isApproved;
	private String image;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datePublished;

	@OneToOne //uni
	@JoinColumn(name = "book_supplier_id")
	private User supplier;
	

	@ManyToMany
	@JoinTable(name = "book_author",
			joinColumns = { @JoinColumn(name = "book_id") },
			inverseJoinColumns = { @JoinColumn(name = "author_id") })
	private List<Author> authors = new ArrayList<Author>();

	@ManyToMany
	@JoinTable(name = "book_category",
			joinColumns = { @JoinColumn(name = "book_id") },
			inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private List<Category> categories = new ArrayList<>();


    @ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String description, String isbn, Double price, Integer copiesNumber, Boolean isApproved,
				String image, LocalDate datePublished, User supplier, List<Author> authors, List<Category> categories) {
		super();
		this.title = title;
		this.description = description;
		this.isbn = isbn;
		this.price = price;
		this.numberOfCopies = copiesNumber;
		this.isApproved = isApproved;
		this.image = image;
		this.datePublished = datePublished;
		this.supplier = supplier;
		this.authors = authors;
		this.categories = categories;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopies(Integer numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getBookImage() {
		return image;
	}

	public void setBookImage(String image) {
		this.image = image;
	}

	public User getSupplier() {
		return supplier;
	}

	public void setSupplier(User supplier) {
		this.supplier = supplier;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Category>  getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Boolean getApproved() {
		return isApproved;
	}

	public void setApproved(Boolean approved) {
		isApproved = approved;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDate getDatePublished() {
		return datePublished;
	}

	public void setAuthor(Author author)
	{
		this.authors.add(author);
	}

	public void setDatePublished(LocalDate datePublished) {
		this.datePublished = datePublished;
	}

	public void setCategory(Category catagory)
	{
		this.categories.add(catagory);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", price=" + price + ", copiesNumber="
				+ numberOfCopies + ", isApproved=" + isApproved + ", supplier=" + supplier + "]";
	}

}