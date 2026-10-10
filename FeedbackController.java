package com.feedback.studentfeedback;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = {
    "http://localhost:5500",
    "http://127.0.0.1:5500"
})
public class FeedbackController {

    private final FeedbackRepository repository;

    public FeedbackController(FeedbackRepository repository) {
        this.repository = repository;
    }

    // Submit feedback
    @PostMapping
    public ResponseEntity<Feedback> submitFeedback(
            @RequestBody Feedback feedback) {

        if (feedback.getRating() == null
                || feedback.getRating() < 1
                || feedback.getRating() > 5) {
            return ResponseEntity.badRequest().build();
        }

        Feedback saved = repository.save(feedback);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saved);
    }

    // View all feedback
    @GetMapping
    public List<Feedback> getAllFeedback() {
        return repository.findAll();
    }

    // View one feedback record
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}