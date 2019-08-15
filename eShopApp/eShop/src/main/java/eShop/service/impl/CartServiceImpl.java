package eShop.service.impl;
import eShop.model.Cart;
import eShop.repository.CartRepository;
import eShop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl  implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Override
    public Cart findCartById(Integer id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public Cart saveCart(Cart cart) {
        return  cartRepository.save(cart);
    }

    @Override
    public Cart findCartBySessionId(String id) {
        return cartRepository.findBySessionId(id);
    }

//   private Customer customer= new Customer();
//   private  String customerUserName=customer.getUsername();
//   private Integer cutomerId=customer.getId();
//   private List<String> coontents;
//
//    @Override
//    public void initializeCart(String userName) {
//        customerUserName=userName;
//        coontents =new ArrayList<>();
//    }
//
//    @Override
//    public void addBookIntoCart(String bookId){
//
//    }
//
//    @Override
//    public void removeBookFromCart(String bookId) {
//
//    }
//
//    @Override
//    public Book findBookById(Integer bookId) {
//
//      return null;
//    }
//
//    @Override
//    public void clearCart() {
//    }
}