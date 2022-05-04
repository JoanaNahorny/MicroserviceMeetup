package com.bootcamp.microservicesmeetup.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetupDTO {

    private Integer id;

    @NotEmpty
    private String registrationAttribute;

    @NotEmpty
    private String event;

    private RegistrationDTO registration;

}
