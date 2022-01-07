package com.FPP.feedbackms.Feedback;

import com.FPP.feedbackms.Person.Person;
import com.FPP.feedbackms.Person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    PersonRepository personRepository;

    public boolean createFeedback(String title, String description, int rating, int personId) throws Exception {
        if (rating<1 || rating>5) {
            throw new Exception("Rating should be between 1-5 points.");
        }

        if (description.length()<3) {
            throw new Exception("Description should be at least 3 chars long.");
        }

        Person feedbackOwner = personRepository.getById(personId);
        Feedback feedback = new Feedback(title, description, rating, feedbackOwner);

        feedbackRepository.save(feedback);
        return true;
    }

    public List<Feedback> getAllFeedback(int personId) {
        return feedbackRepository.findAllByPersonId(personId);
    }

    public boolean updateFeedback(int feedbackId, String title, String description, int rating) {
        Feedback feedback = feedbackRepository.getById(feedbackId);
        feedback.setTitle(title);
        feedback.setDescription(description);
        feedback.setRating(rating);

        feedbackRepository.save(feedback);
        return true;
    }

    public boolean deleteFeedback(int feedbackId) {
        feedbackRepository.deleteById(feedbackId);
        return true;
    }
}
