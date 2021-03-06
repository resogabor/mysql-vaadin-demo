package hu.rate.tanul.jpa.repositories;

import hu.rate.tanul.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameStartsWithIgnoreCase(String name);

}
