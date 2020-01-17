package com.softserve.service.provider.controller;

import com.softserve.service.provider.dto.HistoryDTO;
import com.softserve.service.provider.request.HistoryRequest;
import com.softserve.service.provider.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequestMapping(path = "/history")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<HistoryDTO>> getAll() {
        Iterable<HistoryDTO> dtos = historyService.getAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping(path = "/add/{driverId}")
    public ResponseEntity addHistory(@PathVariable UUID driverId,
                                     @RequestBody @NotNull @Valid HistoryRequest historyRequest) {
        historyService.addByDriverId(driverId, historyRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
