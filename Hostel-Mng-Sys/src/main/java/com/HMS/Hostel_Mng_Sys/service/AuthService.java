package com.HMS.Hostel_Mng_Sys.service;

import com.HMS.Hostel_Mng_Sys.Dto.AuthResponseDto;
import com.HMS.Hostel_Mng_Sys.Dto.LoginRequestDto;
import com.HMS.Hostel_Mng_Sys.Dto.RegisterRequestDto;
import com.HMS.Hostel_Mng_Sys.config.Jwtutils;
import com.HMS.Hostel_Mng_Sys.model.Staff_model;
import com.HMS.Hostel_Mng_Sys.model.Student_model;
import com.HMS.Hostel_Mng_Sys.model.USER_ROLE;
import com.HMS.Hostel_Mng_Sys.model.User_model;
import com.HMS.Hostel_Mng_Sys.repository.Staff_repo;
import com.HMS.Hostel_Mng_Sys.repository.Student_repo;
import com.HMS.Hostel_Mng_Sys.repository.User_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private User_repo userRepo;
    @Autowired
    private Student_repo studentRepo;
    @Autowired
    private Staff_repo staffrepo;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private Jwtutils jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;


    public String register(RegisterRequestDto req) {
        // Step 1: Validate the inputs
        if (req.username == null || req.username.isEmpty()) {
            return "Username cannot be empty";
        }
        if (req.password == null || req.password.isEmpty()) {
            return "Password cannot be empty";
        }
        if (req.role == null || req.role.isEmpty()) {
            return "Role must be specified";
        }

        // Check if username already exists
        if (userRepo.findUserByUsername(req.username).isPresent()) {
            return "Username already exists";
        }

        // Create and save the user
        User_model user = new User_model();
        user.setUsername(req.username);
        user.setPassword(encoder.encode(req.password));
        user.setRole(USER_ROLE.valueOf(req.role)); // Assign role based on input

        user = userRepo.save(user); // Save user to generate ID

        // Based on role, create and save associated model (Student or Staff)
        if (req.role.equalsIgnoreCase("STUDENT")) {
            Student_model student = new Student_model();
            student.setUser(user); // set relationship
            student.setActive(true); // Example field
            studentRepo.save(student);
            return "Student registered successfully";
        } else if (req.role.equalsIgnoreCase("STAFF")) {
            Staff_model staff = new Staff_model();
            staff.setUser(user); // set relationship
            staffrepo.save(staff);
            return "Staff registered successfully";
        } else {
            // For any other role, register as a generic user
            return "User registered successfully";
        }
    }

    public String authenticate(LoginRequestDto req) {
        Authentication auth = new UsernamePasswordAuthenticationToken(req.username, req.password);

        authenticationManager.authenticate(auth);

        // Fetch user by username
        User_model user = userRepo.findUserByUsername(req.username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Generate JWT token based on authenticated principal
        String token = jwtService.generateToken(auth);

        // Return response with token
        return token; // if you want to include role too
    }

}
