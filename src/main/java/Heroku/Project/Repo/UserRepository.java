package Heroku.Project.Repo;

import Heroku.Project.Tables.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
