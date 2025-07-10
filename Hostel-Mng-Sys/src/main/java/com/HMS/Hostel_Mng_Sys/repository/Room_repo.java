package com.HMS.Hostel_Mng_Sys.repository;

import com.HMS.Hostel_Mng_Sys.model.Room_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Room_repo extends JpaRepository<Room_model,Long> {
}
