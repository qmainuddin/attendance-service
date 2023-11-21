package com.example.attendanceservice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;

///**
// * DTO for {@link com.miu.alumnimanagementportal.entities.Attendant}
// */
@Data
public class AttendantDto implements Serializable {
    Long id;
    Long version;
    Date createdDate;
    Date lastModifiedDate;
    @NotNull
    Long userDto_id;
    boolean is_confirmed;
    @NotNull
    Long eventDto_id;
}