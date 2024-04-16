package Heroku.Project.Repo;

import Heroku.Project.Tables.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    // You can define custom query methods here if needed
}
