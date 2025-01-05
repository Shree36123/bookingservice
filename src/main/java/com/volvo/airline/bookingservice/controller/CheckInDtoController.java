package com.volvo.airline.bookingservice.controller;

import com.volvo.airline.bookingservice.mapper.CheckInMapper;
import com.volvo.airline.bookingservice.model.CheckIn;
import com.volvo.airline.bookingservice.model.dao.CheckInDto;
import com.volvo.airline.bookingservice.service.CheckInDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/checkin")
public class CheckInDtoController {

    @Autowired
    private CheckInDtoService checkInDtoService;

    @GetMapping
    public List<CheckInDto> getAllCheckInDtos() {
        return CheckInMapper.checkInDtos(checkInDtoService.getAllCheckInDtos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckIn> getCheckInDtoById(@PathVariable Long id) {
        Optional<CheckIn> checkInDto = checkInDtoService.getCheckInDtoById(id);
        return checkInDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public CheckInDto createCheckInDto(@RequestBody CheckInDto checkInDto) {
        return CheckInMapper.toDTO(
                checkInDtoService.saveCheckInDto(
                        CheckInMapper.toEntity(checkInDto)));
    }

    @PutMapping("/update")
    public ResponseEntity<CheckInDto> updateCheckInDto(@RequestBody CheckInDto checkInDtoDetails) {
        if (Objects.nonNull(checkInDtoDetails.getId())) {
            Optional<CheckIn> checkInDto = checkInDtoService.getCheckInDtoById(checkInDtoDetails.getId());
            if (checkInDto.isPresent()) {
                CheckIn checkIn = CheckInMapper.toEntity(checkInDtoDetails, checkInDto.get());
                checkInDtoService.saveCheckInDto(checkIn);
                return ResponseEntity.ok(CheckInMapper.toDTO(checkIn));
            } else
                return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCheckInDto(@PathVariable Long id) {
        checkInDtoService.deleteCheckInDto(id);
        return ResponseEntity.noContent().build();
    }
}