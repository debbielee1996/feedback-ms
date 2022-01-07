package com.FPP.feedbackms.Person;


import com.FPP.feedbackms.Feedback.Feedback;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy= "person")
    private List<Feedback> feedbackList;

    public Person(String name, String email, String password) {
        this.name=name;
        this.email=email;
        this.password=password;

        this.feedbackList=new ArrayList<>();
    }
}
