package com.driveUp.repos;


import com.driveUp.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepo extends JpaRepository<Transaction, UUID> {
}
