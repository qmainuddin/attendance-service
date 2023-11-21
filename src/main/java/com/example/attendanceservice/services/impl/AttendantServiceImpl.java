package com.example.attendanceservice.services.impl;


import com.example.attendanceservice.common.Converter;
import com.example.attendanceservice.dtos.AttendantDto;
import com.example.attendanceservice.entities.Attendant;
import com.example.attendanceservice.exceptions.DataAlreadyExistException;
import com.example.attendanceservice.exceptions.ResourceNotFoundException;
import com.example.attendanceservice.repositories.AttendantRepository;
import com.example.attendanceservice.services.AttendantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AttendantServiceImpl implements AttendantService {

    private final AttendantRepository attendantRepository;
    private final Converter converter;


    @Override
    public void create(AttendantDto attendantDto) {
        Optional.ofNullable(attendantDto.getId()).ifPresent(id -> {
            if (attendantRepository.existsById(id)) {
                throw new DataAlreadyExistException("Attendant with id " + id + " already exists");
            }
        });
        attendantRepository.save(converter.convert(attendantDto, Attendant.class));
    }

    @Override
    public List<AttendantDto> findAll() {
        return attendantRepository.findAll().stream()
                .map(element -> converter.convert(element, AttendantDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AttendantDto update(AttendantDto attendantDto, Long id) {
        return Optional.ofNullable(attendantDto.getId()).map(entityId -> {
            if (!attendantRepository.existsById(entityId)) {
                throw new ResourceNotFoundException("Attendant with id " + entityId + " not found");
            }
            return converter.convert(attendantRepository.save(converter.convert(attendantDto, Attendant.class)), AttendantDto.class);
        }).orElseThrow(() -> new ResourceNotFoundException("Attendant with id " + id + " not found"));
    }

    @Override
    public AttendantDto getAttendantById(Long id) {
        return Optional.ofNullable(id)
                .map(attendantRepository::findById)
                .map(element -> converter.convert(element, AttendantDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Attendant with id " + id + " not found"));
    }

    @Override
    public void delete(Long id) {
        if (!attendantRepository.existsById(id)) {
            throw new ResourceNotFoundException("Attendent with id " + id + " not found");
        }
        attendantRepository.deleteById(id);

    }
}
