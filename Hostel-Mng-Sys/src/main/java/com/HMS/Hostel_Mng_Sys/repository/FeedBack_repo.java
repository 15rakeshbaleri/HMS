package com.HMS.Hostel_Mng_Sys.repository;

import com.HMS.Hostel_Mng_Sys.model.Feedback_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBack_repo extends JpaRepository<Feedback_model, Integer> {
}
