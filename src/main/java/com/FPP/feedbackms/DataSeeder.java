package com.FPP.feedbackms;

import com.FPP.feedbackms.Feedback.Feedback;
import com.FPP.feedbackms.Feedback.FeedbackRepository;
import com.FPP.feedbackms.Person.Person;
import com.FPP.feedbackms.Person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    PersonRepository userRepository;

    @Bean
    public void seed() {
        Person person1 = new Person("Jennie", "jennie@blackpink.com", "Password1");
        Person person2 = new Person("Rose", "rose@blackpink.com", "Password1");
        Person person3 = new Person("Jisoo", "jisoo@blackpink.com", "Password1");
        Person person4 = new Person("Lisa", "lisa@blackpink.com", "Password1");

        userRepository.save(person1);
        userRepository.save(person2);
        userRepository.save(person3);
        userRepository.save(person4);

        Feedback feedback1 = new Feedback("good cust service", "came to restaurant on 5 May 2021. very pleasant staff", 5, person1);
        Feedback feedback2 = new Feedback("poor cust service", "staff are very rude", 1, person1);

        feedbackRepository.save(feedback1);
        feedbackRepository.save(feedback2);
    }
}
