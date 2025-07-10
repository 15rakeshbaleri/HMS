package com.HMS.Hostel_Mng_Sys.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@Getter
@Setter
public class Student_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign Key to the User table
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User_model user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room_model room;

    @Column(nullable = false)
    private boolean isActive;

    private String department;
    private Integer semester;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Fee_model fee;





    @Column(nullable = false)
    private Boolean gymOptedIn = false;  // Gym opt-in status (default: false)

    @Column(nullable = true)
    private Double gymFee = 500.00;  // Gym fee (500 per month, if opted in)

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Notification_model> notifications;
    // Getter and Setter methods
}
