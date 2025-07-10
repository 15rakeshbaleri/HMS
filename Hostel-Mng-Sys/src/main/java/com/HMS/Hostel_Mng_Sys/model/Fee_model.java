package com.HMS.Hostel_Mng_Sys.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fees")
@Data

public class Fee_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student_model student;


    @Column(nullable = false)
    private Double hostelFee;  // Hostel fee for the student

    @Column(nullable = false)
    private Double totalFee;  // Total fee for the student (calculated field)
}
