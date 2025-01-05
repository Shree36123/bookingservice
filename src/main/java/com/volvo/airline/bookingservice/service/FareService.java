package com.volvo.airline.bookingservice.service;

import com.volvo.airline.bookingservice.model.Fare;
import com.volvo.airline.bookingservice.repository.FareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FareService {

    @Autowired
    private FareRepository fareRepository;

    public List<Fare> getAllFares() {
        return fareRepository.findAll();
    }

    public Optional<Fare> getFareById(Long id) {
        return fareRepository.findById(id);
    }

    public Fare saveFare(Fare fare) {
        return fareRepository.save(fare);
    }

    public void deleteFare(Long id) {
        fareRepository.deleteById(id);
    }
}