package com.softserve.service.provider.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@Builder
public class HistoryRequest {
    private String startPoint;
    private String finishPoint;

    @Positive
    private Double distance;

    @Positive
    private Double travelTime;

    @Positive
    private Double price;

    @PositiveOrZero
    private int fine;

    @PositiveOrZero
    @Max(value = 5)
    private double rating;

    @Size(max = 140)
    private String description;
}
