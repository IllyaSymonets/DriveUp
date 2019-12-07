package com.softserve.service.provider.service;

import com.softserve.service.provider.dto.HistoryDTO;
import com.softserve.service.provider.model.History;
import com.softserve.service.provider.repository.DriverRepository;
import com.softserve.service.provider.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final DriverRepository driverRepository;

    @Autowired
    public HistoryService(HistoryRepository historyRepository, DriverRepository driverRepository) {
        this.historyRepository = historyRepository;
        this.driverRepository = driverRepository;

    }

    public void add(UUID id, HistoryDTO historyDTO) {
        driverRepository.findById(id)
                .map(driver -> {
                    History history = History.builder()
                            .description(historyDTO.getDescription())
                            .distance(historyDTO.getDistance())
                            .fine(historyDTO.getFine())
                            .rating(historyDTO.getRating())
                            .price(historyDTO.getPrice())
                            .startPoint(historyDTO.getStartPoint())
                            .finishPoint(historyDTO.getFinishPoint())
                            .travelTime(historyDTO.getTravelTime())
                            .driverId(id)
                            .build();

                    historyRepository.save(history);
                    return historyDTO;
                })
                .orElseThrow(RuntimeException::new);
    }

    public Iterable<HistoryDTO> getAll() {
        Iterable<History> histories = historyRepository.findAll();
        List<HistoryDTO> dtos = new ArrayList<>();

        for (History history : histories) {
            dtos.add(HistoryDTO.builder()
                    .price(history.getPrice())
                    .travelTime(history.getTravelTime())
                    .startPoint(history.getStartPoint())
                    .finishPoint(history.getFinishPoint())
                    .distance(history.getDistance())
                    .description(history.getDescription())
                    .date(history.getDate())
                    .fine(history.getFine())
                    .rating(history.getRating())
                    .build());
        }

        return dtos;
    }
}
