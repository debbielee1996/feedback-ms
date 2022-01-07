package com.FPP.feedbackms.Feedback;

import com.FPP.feedbackms.Person.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private int rating;

    @JsonIgnore
    @ManyToOne // feedback is the owning side, person is inverse side
    @JoinColumn(name="person_id", nullable=false)
    private Person person;

    public Feedback(String title, String description, int rating, Person person) {
        this.title=title;
        this.description=description;
        this.rating=rating;
        this.person = person;
    }
}
