package com.driveUp.service;

import com.driveUp.exception.DriverNotFoundException;
import com.driveUp.repository.DriverRepository;
import com.driveUp.repository.HistoryRepository;
import com.driveUp.request.HistoryRequest;
import com.driveUp.dto.HistoryDTO;
import com.driveUp.model.History;
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

    public void addByDriverId(UUID driverId, HistoryRequest historyRequest) {
        driverRepository.findById(driverId)
                .map(driver -> {
                    History history = History.builder()
                            .description(historyRequest.getDescription())
                            .distance(historyRequest.getDistance())
                            .fine(historyRequest.getFine())
                            .rating(historyRequest.getRating())
                            .price(historyRequest.getPrice())
                            .startPoint(historyRequest.getStartPoint())
                            .finishPoint(historyRequest.getFinishPoint())
                            .travelTime(historyRequest.getTravelTime())
                            .driverId(driverId)
                            .build();

                    historyRepository.save(history);
                    return historyRequest;
                })
                .orElseThrow(() -> new DriverNotFoundException(driverId));
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
                    .date(history.getDateOfTrip())
                    .fine(history.getFine())
                    .rating(history.getRating())
                    .build());
        }

        return dtos;
    }
}
