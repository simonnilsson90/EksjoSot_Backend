package Heroku.Project.Repo;

import Heroku.Project.Tables.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Here you can define custom database queries if needed
}
