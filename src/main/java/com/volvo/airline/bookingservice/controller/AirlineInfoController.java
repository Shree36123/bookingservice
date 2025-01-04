package com.volvo.airline.bookingservice.controller;

import com.volvo.airline.bookingservice.model.AirlineInfo;
import com.volvo.airline.bookingservice.service.AirlineInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airline-info")
public class AirlineInfoController {
    private final AirlineInfoService airlineInfoService;

    public AirlineInfoController(AirlineInfoService airlineInfoService) {
        this.airlineInfoService = airlineInfoService;
    }

    @GetMapping
    public List<AirlineInfo> getAllAirlineInfos() {
        return airlineInfoService.getAllAirlineInfos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirlineInfo> getAirlineInfoById(@PathVariable Long id) {
        return airlineInfoService.getAirlineInfoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AirlineInfo addAirlineInfo(@RequestBody AirlineInfo airlineInfo) {
        return airlineInfoService.addAirlineInfo(airlineInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirlineInfo> updateAirlineInfo(@PathVariable Long id, @RequestBody AirlineInfo airlineInfo) {
        if (!airlineInfoService.getAirlineInfoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        airlineInfo.setId(id);
        return ResponseEntity.ok(airlineInfoService.updateAirlineInfo(airlineInfo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirlineInfo(@PathVariable Long id) {
        if (!airlineInfoService.getAirlineInfoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        airlineInfoService.deleteAirlineInfo(id);
        return ResponseEntity.noContent().build();
    }
}