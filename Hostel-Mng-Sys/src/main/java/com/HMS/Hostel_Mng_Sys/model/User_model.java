package com.HMS.Hostel_Mng_Sys.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore // Prevents password from being exposed in API responses
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private USER_ROLE role;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true, length = 12)
    private String aadharNumber;

    @Column(nullable = false)
    private LocalDate DOB;

    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = true)
    private String profileImageUrl;

    @Column(nullable = false)
    private LocalDate registrationDate;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setOauth2Id(String oauth2Id) {
        this.oauth2Id = oauth2Id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public boolean isActive() {
        return active;
    }

    public String getOauth2Id() {
        return oauth2Id;
    }

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = true)
    private String oauth2Id;



}
