package Heroku.Project.Repo;

import Heroku.Project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

   User findByEmail(String email);
}
