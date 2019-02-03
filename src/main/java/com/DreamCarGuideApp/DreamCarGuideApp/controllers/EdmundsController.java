package com.DreamCarGuideApp.DreamCarGuideApp.controllers;

import com.DreamCarGuideApp.DreamCarGuideApp.models.EdmundResponse;
import com.DreamCarGuideApp.DreamCarGuideApp.services.EdmundsService;
import com.sun.xml.internal.xsom.impl.util.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

public class EdmundsController {
    @Autowired
    EdmundsService edmundsService;


    @PostMapping("/edmund")
    public ResponseEntity<EdmundResponse> createEdmundResponse(@RequestBody EdmundResponse edmund) {
        return new ResponseEntity<>(edmundsService.save(edmund), HttpStatus.CREATED);
    }

    @GetMapping("/edmund/{id}")
    public ResponseEntity<EdmundResponse> getEdmundResponse(
            @PathVariable String state,
            @PathVariable Integer year,
            @PathVariable String view) {
        RestTemplate restTemplate = new RestTemplate();
        // https://api.edmunds.com/api/vehicle/v2/makes?state=used&year=2014&view=basic&fmt=json&api_key=
        String endpoint = new StringBuilder("https://api.edmunds.com/api/vehicle/v2/makes?state=")
                .append(state) // used
                .append("&year=")
                .append(year) // 2014
                .append("&view=")
                .append(view) // basic, full
                .append("&fmt=json&api_key=")
                .toString();
        EdmundResponse edmundResponse = restTemplate.getForObject(endpoint, EdmundResponse.class);

        Optional<EdmundResponse> edmund = edmundsService.getEdmundResponse(state, year, view, EdmundResponse.class);

        if (!edmund.isPresent()) {
            return new ResponseEntity<>(edmund.get(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(edmund.get(), HttpStatus.OK);
    }

    @GetMapping("/edmund")
    public ResponseEntity<Iterable<EdmundResponse>> getEdmundResponseList() {
        return new ResponseEntity<>(edmundsService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/edmund/{id}")
    public ResponseEntity<EdmundResponse> updateEdmundResponse(@PathVariable Integer id, @RequestBody EdmundResponse updatedEdmundResponse) {
        Optional<EdmundResponse> edmund = edmundsService.findById(id);
        if (!edmund.isPresent()) {
            return new ResponseEntity<>(updatedEdmundResponse, HttpStatus.OK);
        }

        updatedEdmundResponse.setId(id);
        edmundsService.save(updatedEdmundResponse);
        return new ResponseEntity<>(updatedEdmundResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/edmund/{id}")
    public ResponseEntity<?> deleteEdmundResponse(@RequestBody EdmundResponse edmund) {
        edmundsService.delete(edmund);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
