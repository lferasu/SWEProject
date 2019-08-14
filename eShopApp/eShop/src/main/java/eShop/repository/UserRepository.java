package eShop.repository;

import eShop.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(Integer id);
    User findByUsername(String username);
    User findByEmail(String email);
    User findByConfirmationToken(String confirmationToken);
    List<User> findAllByEmailContainsOrUsernameContainsOrLastNameContainsOrFirstNameContainsOrderByFirstName(@Email(message = "Please provide a valid email") @NotEmpty(message = "Please provide an email") String email, @NotEmpty(message = "Please provide your username") String username, @NotEmpty(message = "Please provide your last name") String lastName, @NotEmpty(message = "Please provide your first name") String firstName);

}
