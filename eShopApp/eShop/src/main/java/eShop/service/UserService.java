package eShop.service;

import eShop.model.user.User;

public interface UserService {
    public abstract User findByEmail(String email);
    public abstract User findByUsername(String username);
    public abstract User findByConfirmationToken(String confirmationToken);
    public abstract void saveUser(User user);
}
