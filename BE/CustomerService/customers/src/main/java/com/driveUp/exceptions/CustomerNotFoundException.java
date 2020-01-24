package com.driveUp.exceptions;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(UUID id) {
        super("Incorrect customer-id: " + id);
    }
}

