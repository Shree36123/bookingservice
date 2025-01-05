package com.volvo.airline.bookingservice.service;

import com.volvo.airline.bookingservice.model.CheckIn;
import com.volvo.airline.bookingservice.model.dao.CheckInDto;
import com.volvo.airline.bookingservice.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckInDtoService {

    @Autowired
    private CheckInRepository checkInDtoRepository;

    public List<CheckIn> getAllCheckInDtos() {
        return checkInDtoRepository.findAll();
    }

    public Optional<CheckIn> getCheckInDtoById(Long id) {
        return checkInDtoRepository.findById(id);
    }

    public CheckIn saveCheckInDto(CheckIn checkInDto) {
        return checkInDtoRepository.save(checkInDto);
    }

    public void deleteCheckInDto(Long id) {
        checkInDtoRepository.deleteById(id);
    }
}