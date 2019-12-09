package com.softserve.service.provider.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class HistoryDTO {
    private Date date;
    private String startPoint;
    private String finishPoint;
    private Double distance;
    private Double travelTime;
    private Double price;
    private int fine;
    private double rating;
    private String description;
}
