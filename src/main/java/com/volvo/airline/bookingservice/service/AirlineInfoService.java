package com.volvo.airline.bookingservice.service;

import com.volvo.airline.bookingservice.model.AirlineInfo;
import com.volvo.airline.bookingservice.repository.AirlineInfoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineInfoService {
    private final AirlineInfoRepo airlineInfoRepo;

    public AirlineInfoService(AirlineInfoRepo airlineInfoRepo) {
        this.airlineInfoRepo = airlineInfoRepo;
    }

    public List<AirlineInfo> getAllAirlineInfos() {
        return airlineInfoRepo.findAll();
    }

    public Optional<AirlineInfo> getAirlineInfoById(Long id) {
        return airlineInfoRepo.findById(id);
    }

    public AirlineInfo addAirlineInfo(AirlineInfo airlineInfo) {
        return airlineInfoRepo.save(airlineInfo);
    }

    public AirlineInfo updateAirlineInfo(AirlineInfo airlineInfo) {
        return airlineInfoRepo.save(airlineInfo);
    }

    public void deleteAirlineInfo(Long id) {
        airlineInfoRepo.deleteById(id);
    }
}