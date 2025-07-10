package com.HMS.Hostel_Mng_Sys.repository;

import com.HMS.Hostel_Mng_Sys.model.User_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User_repo extends JpaRepository<User_model, Integer> {


    Optional<User_model> findUserByUsername(String username);
}
