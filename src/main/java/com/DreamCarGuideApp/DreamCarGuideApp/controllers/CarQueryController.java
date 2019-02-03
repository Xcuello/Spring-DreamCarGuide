package com.DreamCarGuideApp.DreamCarGuideApp.controllers;

import com.DreamCarGuideApp.DreamCarGuideApp.models.CarQueryResponse;
import com.DreamCarGuideApp.DreamCarGuideApp.services.CarQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class CarQueryController {
    @Autowired
    CarQueryService carquerysService;


    @PostMapping("/carquery")
    public ResponseEntity<CarQueryResponse> createCarQueryResponse(@RequestBody CarQueryResponse carquery) {
        return new ResponseEntity<>(carquerysService.save(carquery), HttpStatus.CREATED);
    }

    @GetMapping("/carquery/{id}")
    public ResponseEntity<CarQueryResponse> getCarQueryResponse(
            @PathVariable String make,
            @PathVariable Integer year,
            @PathVariable String body) {
        //ford&year=2005&&body=SUV
        String endpoint = new StringBuilder("https://www.carqueryapi.com/api/0.3/?callback=?&cmd=getModels&make=")
                .append(make) // ford, honda,
                .append("&year=")
                .append(year) // 2005
                .append("sold_in_us=1")
                .append("&body=")
                .append(body) // suv, sedan
                .toString();

        Optional<CarQueryResponse> carquery = carquerysService.getCarQueryResponse(make, year, body, CarQueryResponse.class);
        if (!carquery.isPresent()) {
            return new ResponseEntity<>(carquery.get(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carquery.get(), HttpStatus.OK);
    }

    @GetMapping("/carquery")
    public ResponseEntity<Iterable<CarQueryResponse>> getCarQueryResponseList() {
        return new ResponseEntity<>(carquerysService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/carquery/{id}")
    public ResponseEntity<CarQueryResponse> updateCarQueryResponse(@PathVariable Integer id, @RequestBody CarQueryResponse updatedCarQueryResponse) {
        Optional<CarQueryResponse> carquery = carquerysService.findById(id);
        if (!carquery.isPresent()) {
            return new ResponseEntity<>(updatedCarQueryResponse, HttpStatus.OK);
        }

        updatedCarQueryResponse.setId(id);
        carquerysService.save(updatedCarQueryResponse);
        return new ResponseEntity<>(updatedCarQueryResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/carquery/{id}")
    public ResponseEntity<?> deleteCarQueryResponse(@RequestBody CarQueryResponse carquery) {
        carquerysService.delete(carquery);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
