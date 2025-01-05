package com.volvo.airline.bookingservice.controller;

import com.volvo.airline.bookingservice.model.Flight;
import com.volvo.airline.bookingservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        Optional<Flight> flight = flightService.getFlightById(id);
        return flight.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flightDetails) {
        Optional<Flight> flight = flightService.getFlightById(id);
        if (flight.isPresent()) {
            Flight updatedFlight = flight.get();
            updatedFlight.setDestination(flightDetails.getDestination());
            updatedFlight.setFlightNumber(flightDetails.getFlightNumber());
            updatedFlight.setOrigin(flightDetails.getOrigin());
            updatedFlight.setTime(flightDetails.getTime());
            updatedFlight.setDate(flightDetails.getDate());
            updatedFlight.setFlightTime(flightDetails.getFlightTime());
            updatedFlight.setNumberOfSeats(flightDetails.getNumberOfSeats());
            updatedFlight.setAirlineId(flightDetails.getAirlineId());
            return ResponseEntity.ok(flightService.saveFlight(updatedFlight));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}