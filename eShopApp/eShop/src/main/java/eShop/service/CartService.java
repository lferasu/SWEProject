package eShop.service;


import eShop.model.Book;
import eShop.model.Cart;

import java.util.List;
public interface CartService {
//    public abstract  void initializeCart(String person);
//    public abstract void addBookIntoCart(String bookId);
//    public abstract void removeBookFromCart(String bookId);
//    public abstract Book findBookById(Integer bookId);
//    //public List<String> getCartContent();
//    public void clearCart();

    public Cart findCartById(Integer id);
    public Cart saveCart(Cart cart);
    public Cart findCartBySessionId(String id);
}
