package com.driveUp.repositories;

import com.driveUp.models.Bill;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BillRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BillRepository billRepository;


    @Test
    public void findAllBills() {
        List<Bill> billToDB = new ArrayList<>();
        billToDB.add(new Bill(UUID.fromString("f0e7a8ff-d0d9-4bea-8a5e-55cd0ce30604"),
                BigDecimal.valueOf(112.00), "CASH", true));
        billToDB.add(new Bill(UUID.fromString("f0458b91-35ad-4090-9ea6-9e89020bd014"),
                BigDecimal.valueOf(152.00), "CARD", true));
        billToDB.add(new Bill(UUID.fromString("56d4d4ca-cb27-4b4e-aebf-fd8d81d38249"),
                BigDecimal.valueOf(132.00), "CASH", true));
        billToDB.add(new Bill(UUID.fromString("b5ab7253-e67f-4a48-91c6-161ed5ffdd0e"),
                BigDecimal.valueOf(115.00), "CASH", true));
        for (Bill bill : billToDB) {
            entityManager.persist(bill);
            entityManager.flush();
        }
        List<Bill> billFromDB = billRepository.findAll();

        Assert.assertEquals(billFromDB, billToDB);
    }
}