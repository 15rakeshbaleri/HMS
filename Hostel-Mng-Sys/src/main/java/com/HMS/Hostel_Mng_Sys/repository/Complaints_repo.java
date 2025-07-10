package com.HMS.Hostel_Mng_Sys.repository;

import com.HMS.Hostel_Mng_Sys.model.Complaints_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Complaints_repo extends JpaRepository<Complaints_model, Integer> {
}
