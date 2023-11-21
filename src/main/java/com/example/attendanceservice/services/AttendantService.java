package com.example.attendanceservice.services;


import com.example.attendanceservice.dtos.AttendantDto;

import java.util.List;

public interface AttendantService {
    void create(AttendantDto attendantDto);

    List<AttendantDto> findAll();

    AttendantDto update(AttendantDto attendantDto, Long id);

    AttendantDto getAttendantById(Long id);

    void delete(Long id);
}

