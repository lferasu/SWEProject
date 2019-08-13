package eShop.service;


import eShop.model.Book;

import java.util.List;
public interface CartService {
    public abstract  void initializeCart(String person);
    public abstract void addBookIntoCart(String bookId);
    public abstract void removeBookFromCart(String bookId);
    public abstract Book findById(String BookId);
    //public List<String> getCartContent();
    public void clearCart();
}
