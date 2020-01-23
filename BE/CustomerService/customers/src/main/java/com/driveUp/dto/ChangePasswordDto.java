package com.driveUp.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ChangePasswordDto {
    UUID customerId;
    String oldPassword;
    String newPassword;
}
