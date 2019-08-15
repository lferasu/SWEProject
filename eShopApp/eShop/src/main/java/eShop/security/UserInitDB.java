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
            User supplier1 = new User("supplier1", passwordEncoder.encode("supplier1"), Role.SUPPLIER, "", "Supplier's FirstName", "Supplier's LastName", "shirmen.sodbileg1@gmail.com", true);
            User supplier2 = new User("supplier2", passwordEncoder.encode("supplier2"), Role.SUPPLIER, "", "Supplier's FirstName", "Supplier's LastName", "shirmen.sodbileg2@gmail.com", true);
            user.setConfirmationToken("confirmed");
            admin.setConfirmationToken("confirmed");
            supplier.setConfirmationToken("confirmed");

            this.userRepository.saveAll(Arrays.asList(user, admin, supplier, supplier1, supplier2));
        }
    }
}
