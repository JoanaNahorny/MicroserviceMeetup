package com.bootcamp.microservicesmeetup.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Meetup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String event;

    @JoinColumn(name = "id_registration")
    @ManyToOne
    private Registration registration;

    @Column
    private String meetupDate;

    @Column
    private String registrationAttribute;

    @Column
    private Boolean registered;

    public void registrationAttribute(String registrationAttribute) {
    }
}
