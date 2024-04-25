package Heroku.Project.Repo;


import Heroku.Project.Entity.Dataset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatasetRepository extends JpaRepository<Dataset, Long> {
}
