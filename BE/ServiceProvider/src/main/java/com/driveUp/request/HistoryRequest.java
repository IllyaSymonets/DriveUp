package com.driveUp.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class HistoryRequest {
    @NotBlank
    private String startPoint;

    @NotBlank
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
