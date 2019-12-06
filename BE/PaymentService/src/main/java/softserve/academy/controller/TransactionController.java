package softserve.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import softserve.academy.domain.Transaction;
import softserve.academy.repos.TransactionRepo;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionRepo transactionRepo;

    @GetMapping("getTransactions")
    public Iterable<Transaction> changeActualDetails() {
        return transactionRepo.findAll();
    }
}
