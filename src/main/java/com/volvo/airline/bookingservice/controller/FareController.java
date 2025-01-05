package com.volvo.airline.bookingservice.controller;

import com.volvo.airline.bookingservice.model.Fare;
import com.volvo.airline.bookingservice.service.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fares")
public class FareController {

    @Autowired
    private FareService fareService;

    @GetMapping
    public List<Fare> getAllFares() {
        return fareService.getAllFares();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fare> getFareById(@PathVariable Long id) {
        Optional<Fare> fare = fareService.getFareById(id);
        return fare.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Fare createFare(@RequestBody Fare fare) {
        return fareService.saveFare(fare);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fare> updateFare(@PathVariable Long id, @RequestBody Fare fareDetails) {
        Optional<Fare> fare = fareService.getFareById(id);
        if (fare.isPresent()) {
            Fare updatedFare = fare.get();
            updatedFare.setCurrency(fareDetails.getCurrency());
            updatedFare.setFare(fareDetails.getFare());
            return ResponseEntity.ok(fareService.saveFare(updatedFare));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFare(@PathVariable Long id) {
        fareService.deleteFare(id);
        return ResponseEntity.noContent().build();
    }
}