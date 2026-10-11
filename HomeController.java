
package com.example.StudentFeedback;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
            "message", "Student Feedback System Backend is running!",
            "status", "success",
            "api", "/api/feedback"
        );
    }
}
