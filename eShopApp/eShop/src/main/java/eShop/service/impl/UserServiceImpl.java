package eShop.service.impl;

import eShop.model.user.Address;
import eShop.model.user.User;
import eShop.repository.CustomerRepository;
import eShop.repository.UserRepository;
import eShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsersByText(String text) {
        return userRepository.findAllByEmailContainsOrUsernameContainsOrLastNameContainsOrFirstNameContainsOrderByFirstName(text,text,text,text);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByConfirmationToken(String confirmationToken) {
        return userRepository.findByConfirmationToken(confirmationToken);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Address getAddress(Integer id) {
         return  customerRepository.findById(id).orElse(null).getShippingAddress();
    }
}
