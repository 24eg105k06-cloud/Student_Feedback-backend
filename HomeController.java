@GetMapping("/")
public Map<String, String> home() {
    return Map.of(
        "message", "Student Feedback System Backend is running!",
        "status", "success",
        "feedbackApi", "/api/feedback"
    );
}

@GetMapping("/health")
public Map<String, String> health() {
    return Map.of("status", "UP");
}