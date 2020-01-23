package com.driveUp.repositories;

import com.driveUp.models.Fund;
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

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FundRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FundRepository fundRepository;

    @Test
    public void findAll() {
        List<Fund> fundToDB = new ArrayList<>();
        fundToDB.add(new Fund(UUID.fromString("f0e7a8ff-d0d9-4bea-8a5e-55cd0ce30604"),
                BigDecimal.valueOf(112.00)));
        fundToDB.add(new Fund(UUID.fromString("f0458b91-35ad-4090-9ea6-9e89020bd014"),
                BigDecimal.valueOf(152.00)));
        fundToDB.add(new Fund(UUID.fromString("56d4d4ca-cb27-4b4e-aebf-fd8d81d38249"),
                BigDecimal.valueOf(132.00)));
        fundToDB.add(new Fund(UUID.fromString("b5ab7253-e67f-4a48-91c6-161ed5ffdd0e"),
                BigDecimal.valueOf(115.00)));
        for (Fund fund : fundToDB) {
            entityManager.persist(fund);
            entityManager.flush();
        }
        List<Fund> fundFromDB = fundRepository.findAll();

        Assert.assertEquals(fundFromDB, fundToDB);

    }

    @Test
    public void findByDriverId() {
        Fund newDriver = new Fund(UUID.fromString("f0458b91-35ad-4090-9ea6-9e89020bd014"),
                BigDecimal.valueOf(100.00));
        entityManager.persist(newDriver);
        entityManager.flush();

        Fund driverFomDB = fundRepository.findByDriverId(UUID.fromString("f0458b91-35ad-4090-9ea6-9e89020bd014"));

        assertThat(driverFomDB.getId())
                .isEqualTo(newDriver.getId());
    }
}