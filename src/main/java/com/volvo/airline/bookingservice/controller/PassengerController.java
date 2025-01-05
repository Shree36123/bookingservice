package com.volvo.airline.bookingservice.controller;

import com.volvo.airline.bookingservice.model.Passenger;
import com.volvo.airline.bookingservice.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) {
        Optional<Passenger> passenger = passengerService.getPassengerById(id);
        return passenger.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.savePassenger(passenger);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger passengerDetails) {
        Optional<Passenger> passenger = passengerService.getPassengerById(id);
        if (passenger.isPresent()) {
            Passenger updatedPassenger = passenger.get();
            updatedPassenger.setEmail(passengerDetails.getEmail());
            updatedPassenger.setFirstName(passengerDetails.getFirstName());
            updatedPassenger.setGender(passengerDetails.getGender());
            updatedPassenger.setLastName(passengerDetails.getLastName());
            updatedPassenger.setMobileNumber(passengerDetails.getMobileNumber());
            updatedPassenger.setBookingRecord(passengerDetails.getBookingRecord());
            return ResponseEntity.ok(passengerService.savePassenger(updatedPassenger));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
}