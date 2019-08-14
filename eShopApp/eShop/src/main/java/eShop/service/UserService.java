package eShop.service;

import eShop.model.user.Address;
import eShop.model.user.User;

import java.util.List;

public interface UserService {
    public abstract User findById(Integer id);
    public abstract User findByEmail(String email);
    public abstract List<User> findAllUsersByText(String text);
    public abstract User findByUsername(String username);
    public abstract User findByConfirmationToken(String confirmationToken);
    public abstract void saveUser(User user);
    public abstract Address getAddress(Integer id);
}
