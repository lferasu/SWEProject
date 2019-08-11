package eShop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import eShop.model.user.Author;
import eShop.model.user.Supplier;

@Entity
public class Book {
	
	@Id@GeneratedValue
	private Integer id;
	private String title;
	private String isbn;
	private Double price;
	private Integer copiesNumber;
	private Boolean isApproved;
	
	@OneToOne //uni
	@JoinColumn(name = "book_supplier_id")
	private Supplier supplier;
	
	//Many to many books <-> authors	
	@ManyToMany
    @JoinTable(name = "book_author", 
        joinColumns = { @JoinColumn(name = "book_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "author_id") })
	private List<Author> authors = new ArrayList<Author>();
	
	@OneToMany
	@JoinColumn(name="fk_book")
	private List<Category> categories = new ArrayList<Category>();
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String isbn, Double price, Integer copiesNumber, Boolean isApproved, Supplier supplier,
			List<Author> authors, List<Category> categories) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.copiesNumber = copiesNumber;
		this.isApproved = isApproved;
		this.supplier = supplier;
		this.authors = authors;
		this.categories = categories;
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
	public Integer getCopiesNumber() {
		return copiesNumber;
	}
	public void setCopiesNumber(Integer copiesNumber) {
		this.copiesNumber = copiesNumber;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", price=" + price + ", copiesNumber="
				+ copiesNumber + ", isApproved=" + isApproved + ", supplier=" + supplier + ", authors=" + authors
				+ ", categories=" + categories + "]";
	}

}
