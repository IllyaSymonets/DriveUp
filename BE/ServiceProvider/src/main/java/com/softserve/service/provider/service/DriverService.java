package com.softserve.service.provider.service;

import com.softserve.service.provider.dto.CarDTO;
import com.softserve.service.provider.dto.DriverDTO;
import com.softserve.service.provider.dto.DriverProfileDTO;
import com.softserve.service.provider.dto.HistoryDTO;
import com.softserve.service.provider.exception.DriverNotFoundException;
import com.softserve.service.provider.model.Driver;
import com.softserve.service.provider.model.History;
import com.softserve.service.provider.repository.DriverRepository;
import com.softserve.service.provider.repository.HistoryRepository;
import com.softserve.service.provider.request.DriverFineRequest;
import com.softserve.service.provider.request.AddDriverRequest;
import com.softserve.service.provider.request.SearchCarRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;
    private final HistoryRepository historyRepository;
    private final JdbcTemplate jdbcTemplate;

    public void add(AddDriverRequest addDriverRequest) {
        Driver driver = Driver.builder()
                .city(addDriverRequest.getCity())
                .licence(addDriverRequest.getLicence())
                .build();
        driverRepository.save(driver);
    }

    public Iterable<DriverDTO> getAll() {
        Iterable<Driver> drivers = driverRepository.findAll();
        List<DriverDTO> dtos = new ArrayList<>();

        for (Driver driver : drivers) {
            dtos.add(getDriverDTO(driver));
        }
        return dtos;
    }

    public Double getRating(UUID id) {
        Double rating = driverRepository.getDriverRating(id);

        if (rating == null) {
            throw new DriverNotFoundException(id);
        }

        return rating;
    }

    public void updateFine(UUID id, DriverFineRequest driverFineRequest) {
        driverRepository.findById(id)
                .map(driver -> {
                    driver.setFine(driver.getFine() + driverFineRequest.getFine());
                    driverRepository.save(driver);

                    return getDriverDTO(driver);
                })
                .orElseThrow(() -> new DriverNotFoundException(id));
    }

    public void updateDriver(UUID id, AddDriverRequest addDriverRequest) {
        driverRepository.findById(id)
                .map(driver -> {
                    driver.setLicence(addDriverRequest.getLicence());
                    driver.setCity(addDriverRequest.getCity());
                    driverRepository.save(driver);
                    return getDriverDTO(driver);
                })
                .orElseThrow(() -> new DriverNotFoundException(id));
    }

    public void updateRating(UUID id) {
        driverRepository.findById(id)
                .map(driver -> {
                    driver.setRating(getRating(id));
                    driverRepository.save(driver);

                    return getDriverDTO(driver);
                })
                .orElseThrow(() -> new DriverNotFoundException(id));

    }

    public DriverProfileDTO getProfile(UUID id) {

        List<History> histories = historyRepository.findAllByDriverId(id);
        List<HistoryDTO> historyDTOList = new ArrayList<>();

        createHistoryDTO(histories, historyDTOList);

        return driverRepository.findById(id)
                .map(driver -> {
                    CarDTO carDTO = CarDTO.builder()
                            .babyCarSeat(driver.getCar().isBabyCarSeat())
                            .brand(driver.getCar().getBrand())
                            .licencePlate(driver.getCar().getLicencePlate())
                            .colour(driver.getCar().getColour())
                            .type(driver.getCar().getType())
                            .conditioner(driver.getCar().isConditioner())
                            .courier(driver.getCar().isCourier())
                            .english(driver.getCar().isEnglish())
                            .model(driver.getCar().getModel())
                            .nonSmoker(driver.getCar().isNonSmoker())
                            .numberOfSeats(driver.getCar().getNumberOfSeats())
                            .pet(driver.getCar().isPet())
                            .silence(driver.getCar().isSilence())
                            .yearOfProduction(driver.getCar().getYearOfProduction())
                            .build();


                    DriverDTO driverDTO = DriverDTO.builder()
                            .city(driver.getCity())
                            .licence(driver.getLicence())
                            .fine(driver.getFine())
                            .rating(driver.getRating())
                            .build();


                    return DriverProfileDTO.builder()
                            .histories(historyDTOList)
                            .car(carDTO)
                            .driverDTO(driverDTO)
                            .build();
                })
                .orElseThrow(() -> new DriverNotFoundException(id));
    }

    private void createHistoryDTO(List<History> histories, List<HistoryDTO> historyDTOList) {
        for (History history : histories) {
            HistoryDTO historyDTO = HistoryDTO.builder()
                    .date(history.getDateOfTrip())
                    .description(history.getDescription())
                    .distance(history.getDistance())
                    .finishPoint(history.getFinishPoint())
                    .startPoint(history.getStartPoint())
                    .price(history.getPrice())
                    .fine(history.getFine())
                    .rating(history.getRating())
                    .travelTime(history.getTravelTime())
                    .build();

            historyDTOList.add(historyDTO);
        }
    }

    public List<UUID> findDrivers(SearchCarRequest searchCarRequest) {
        String sql = getSqlQuery(searchCarRequest);

        List<UUID> carsId = jdbcTemplate.queryForList(sql, UUID.class);
        List<UUID> driversId = new ArrayList<>();

        for (UUID uuid : carsId) {
            Driver driver = driverRepository.findDriverByCarId(uuid);
            driversId.add(driver.getId());
        }

        return driversId;
    }

    private String getSqlQuery(SearchCarRequest searchCarRequest) {
        return String.format("SELECT distinct vehicle_id FROM CARS where" +
                        " car_type = '%s' and" +
                        " baby_car_seat = '%s' and" +
                        " conditioner = '%s' and" +
                        " courier = '%s' and" +
                        " english = '%s' and" +
                        " non_smoker = '%s' and" +
                        " pet = '%s' and" +
                        " silence = '%s'",
                searchCarRequest.getType(),
                searchCarRequest.isBabyCarSeat(),
                searchCarRequest.isConditioner(),
                searchCarRequest.isCourier(),
                searchCarRequest.isEnglish(),
                searchCarRequest.isNonSmoker(),
                searchCarRequest.isPet(),
                searchCarRequest.isSilence());
    }

    private DriverDTO getDriverDTO(Driver driver) {
        return DriverDTO.builder()
                .licence(driver.getLicence())
                .city(driver.getCity())
                .fine(driver.getFine())
                .rating(driver.getRating())
                .build();
    }
}
