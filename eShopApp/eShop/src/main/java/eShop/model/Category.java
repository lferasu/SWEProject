package eShop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
	
	@Id@GeneratedValue
	private Integer id;
	private String name;
	@ManyToMany(mappedBy="categories")
	private List<Book> books = new ArrayList<Book>();

	public Category(String name, List<Book> books) {
		this.name = name;
		this.books = books;
	}


	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}



	public Category(String name) {
		super();
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	

}
