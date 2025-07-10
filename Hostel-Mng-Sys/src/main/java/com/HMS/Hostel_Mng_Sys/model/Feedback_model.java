package com.HMS.Hostel_Mng_Sys.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "feedbacks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class    Feedback_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student_model student;  // Foreign Key to the Student

    @Column(nullable = false)
    private String content;  // Feedback content

    private String comments;  // Optional comments, if any

    private LocalDate feedbackDate;  // Date of submission

}
