package eShop.security;

import eShop.model.user.Role;
import eShop.model.user.User;
import eShop.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserInitDB implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
public UserInitDB(UserRepository userRepository, PasswordEncoder passwordEncoder){
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
}
    @Override
    public void run(String... args) throws Exception {



        if(userRepository.count() == 0) {

            //create users
            User user = new User("user", passwordEncoder.encode("user"), Role.CUSTOMER, "", "User's FirstName", "User's LastName", "sdblg@yahoo.com", true);
            User admin = new User("admin", passwordEncoder.encode("admin"), Role.ADMIN, "", "Admin's FirstName", "Admin's LastName", "sshirmen@mum.edu", true);
            User supplier = new User("supplier", passwordEncoder.encode("supplier"), Role.SUPPLIER, "", "Supplier's FirstName", "Supplier's LastName", "shirmen.sodbileg@gmail.com", true);

            this.userRepository.saveAll(Arrays.asList(user, admin, supplier));
        }
    }
}
