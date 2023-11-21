package com.example.attendanceservice.controllers;

import com.example.attendanceservice.common.Converter;
import com.example.attendanceservice.dtos.AttendantDto;
import com.example.attendanceservice.services.AttendantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    private final AttendantService attendantService;
    private final Converter converter;



    @PostMapping
    public ResponseEntity<?> createAttendance(@Valid @RequestBody AttendantDto attendantDto) {
        attendantService.create(attendantDto);
        return converter.buildReposeEntity(Map.of("message", "Attendant created successfully"), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<?> getAttendantAll() {
        return converter.buildReposeEntity(Map.of("data", attendantService.findAll()), HttpStatus.ACCEPTED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateAttendantById( @PathVariable Long id,@Valid @RequestBody AttendantDto attendantDto) {
        return converter.buildReposeEntity(Map.of("data", attendantService.update(attendantDto,id)), HttpStatus.OK);
    }






}

