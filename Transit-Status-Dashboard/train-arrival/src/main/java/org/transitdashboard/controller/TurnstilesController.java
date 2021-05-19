package org.transitdashboard.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.transitdashboard.domain.TurnstilesEvent;
import org.transitdashboard.producer.TurnstilesProducer;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
@Slf4j

public class TurnstilesController {

    @Autowired
    private TurnstilesProducer turnstilesProducer;

    @PostMapping("/v1/turnstiles")
    public ResponseEntity<TurnstilesEvent> postTurnstilesEvent(@RequestBody @Valid TurnstilesEvent turnstilesEvent) throws JsonProcessingException, ExecutionException, InterruptedException {

        turnstilesProducer.processTurnstilesEvent(turnstilesEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(turnstilesEvent);
    }

}
