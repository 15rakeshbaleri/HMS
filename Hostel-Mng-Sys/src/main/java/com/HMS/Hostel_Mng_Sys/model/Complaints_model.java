package com.HMS.Hostel_Mng_Sys.model;

import com.HMS.Hostel_Mng_Sys.model.Complaints_category;
import com.HMS.Hostel_Mng_Sys.model.Student_model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "complaints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Complaints_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student_model student;  // Foreign Key to the Student

    @Column(nullable = false)
    private String complaintText;  // Complaint content

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Complaints_category category;  // Category of the complaint (e.g., MESS, GYM)

    private String status = "PENDING";  // Status of the complaint (e.g., PENDING, RESOLVED)

    private LocalDate complaintDate;  // Date of complaint submission

}
