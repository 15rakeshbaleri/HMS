package com.HMS.Hostel_Mng_Sys.Dto;

import lombok.Data;

@Data
public class RegisterRequestDto {
    public String username;
    public String password;
    public String role;
}

