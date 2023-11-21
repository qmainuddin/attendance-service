package com.example.attendanceservice.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Attendant extends BaseEntity{

    private Long user_id;

    @Column(columnDefinition = "boolean default false")
    private boolean is_confirmed;

    private Long event_id;

}

