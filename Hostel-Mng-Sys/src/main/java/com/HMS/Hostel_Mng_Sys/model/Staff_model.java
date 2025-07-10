package com.HMS.Hostel_Mng_Sys.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "staff")
@Data
public class Staff_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign Key to the User table
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User_model user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Designation_staff designation;
    private Double salary;  // Staff-specific field

    // Getter and Setter methods
}

