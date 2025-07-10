package com.HMS.Hostel_Mng_Sys.repository;

import com.HMS.Hostel_Mng_Sys.model.Staff_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Staff_repo extends JpaRepository<Staff_model, Integer> {
}
