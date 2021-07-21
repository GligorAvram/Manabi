package ro.manabi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.manabi.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);

}
	