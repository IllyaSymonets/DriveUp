package com.driveUp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class ChangePasswordDto {

    @NotNull
    UUID customerId;

    @NotNull
    String oldPassword;

    @NotNull
    String newPassword;
}
