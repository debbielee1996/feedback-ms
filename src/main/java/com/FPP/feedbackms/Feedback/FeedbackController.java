package com.FPP.feedbackms.Feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @PostMapping("/createFeedback")
    public boolean createFeedback(@RequestParam("title") String title,
                                   @RequestParam("description") String description,
                                   @RequestParam("rating") int rating,
                                   @RequestParam("personId") int personId) throws Exception {
        return feedbackService.createFeedback(title, description, rating, personId);
    }

    @GetMapping("/getAllFeedback")
    public List<Feedback> getAllFeedback(@RequestParam("personId") int personId) {
        return feedbackService.getAllFeedback(personId);
    }

    @PutMapping("/updateFeedback")
    public boolean updateFeedback(@RequestParam("feedbackId") int feedbackId,
                               @RequestParam("title") String title,
                               @RequestParam("description") String description,
                               @RequestParam("rating") int rating) {
        return feedbackService.updateFeedback(feedbackId, title, description, rating);
    }

    @DeleteMapping("/deleteFeedback")
    public boolean deleteFeedback(@RequestParam("feedbackId") int feedbackId) {
        return feedbackService.deleteFeedback(feedbackId);
    }
}
