package com.wipro.tausif.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.tausif.entity.Feedback;


public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
