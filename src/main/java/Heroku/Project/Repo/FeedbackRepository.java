package Heroku.Project.Repo;

import Heroku.Project.Tables.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // Here you can define custom database queries, if needed
}
