package com.HMS.Hostel_Mng_Sys.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="gym_subscription")
@Data
public class GymSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student_model student;

    private LocalDate startDate;
    private LocalDate endDate;
    private Double amountPaid;
    private String planType;
}
