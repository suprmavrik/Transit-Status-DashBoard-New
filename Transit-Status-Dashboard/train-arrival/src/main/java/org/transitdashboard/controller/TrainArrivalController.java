package org.transitdashboard.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.transitdashboard.domain.TrainArrival;
import org.transitdashboard.domain.TrainArrivalEvent;
import org.transitdashboard.producer.TrainArrivalProducer;
import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
@Slf4j
public class TrainArrivalController {

    @Autowired
    TrainArrivalProducer trainArrivalProducer;


    @PostMapping("/v1/trainarrival")
    public ResponseEntity<TrainArrivalEvent> postTrainArrival(@RequestBody @Valid TrainArrivalEvent trainArrivalEvent) throws JsonProcessingException, ExecutionException, InterruptedException {

        trainArrivalProducer.sendTrainArrivalEvent(trainArrivalEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(trainArrivalEvent);
    }
}
