package com.wipro.tausif.controller;




import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.tausif.entity.Feedback;
import com.wipro.tausif.repository.FeedbackRepository;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:4200")  // Allow Angular frontend
public class FeedbackController {

    private final FeedbackRepository feedbackRepository;

    public FeedbackController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

 // POST - Save feedback
    @PostMapping
    public ResponseEntity<String> submitFeedback(@Valid @RequestBody Feedback feedback) {
        feedbackRepository.save(feedback);
        return ResponseEntity.ok("✅ Thank you! We will get back to you shortly.");
    }
    
 // GET - Fetch all feedback
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        List<Feedback> feedbackList = feedbackRepository.findAll();
        return ResponseEntity.ok(feedbackList);
    }
}
