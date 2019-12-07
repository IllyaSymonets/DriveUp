package com.softserve.service.provider.repository;

import com.softserve.service.provider.model.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HistoryRepository extends CrudRepository<History, UUID> {
    List<History> findAllByDriverId(UUID id);
}
