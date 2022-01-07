package com.FPP.feedbackms.Feedback;

import com.FPP.feedbackms.Person.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class FeedbackServiceTest {
    @Mock FeedbackRepository feedbackRepository;
    @Mock PersonRepository personRepository;
    @InjectMocks FeedbackService feedbackService;

    @Test
    public void createFeedback_GivenParamsValidationOk_shouldReturnTrue() throws Exception {
        // arrange, act & assert
        assertThat(feedbackService.createFeedback("title", "description", 1, 1)).isTrue();

    }

    @Test
    public void createFeedback_GivenRatingNotBetween1And5_shouldThrowException() {
        Exception exception = assertThrows(Exception.class, () -> feedbackService.createFeedback("title", "description", 0, 1));
        assertThat(exception.getMessage()).isEqualTo("Rating should be between 1-5 points.");
    }

    @Test
    public void createFeedback_GivenShortDescription_shouldThrowException() {
        Exception exception = assertThrows(Exception.class, () -> feedbackService.createFeedback("title", "d", 1, 1));
        assertThat(exception.getMessage()).isEqualTo("Description should be at least 3 chars long.");
    }

    // need to create tests for methods that calls on repo directly?
}
