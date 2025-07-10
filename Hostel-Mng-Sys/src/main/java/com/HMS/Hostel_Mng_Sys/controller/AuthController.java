package com.HMS.Hostel_Mng_Sys.controller;

import com.HMS.Hostel_Mng_Sys.Dto.AuthResponseDto;
import com.HMS.Hostel_Mng_Sys.Dto.LoginRequestDto;
import com.HMS.Hostel_Mng_Sys.Dto.RegisterRequestDto;
import com.HMS.Hostel_Mng_Sys.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto request) {

        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto request) {
      String response = authService.authenticate(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
