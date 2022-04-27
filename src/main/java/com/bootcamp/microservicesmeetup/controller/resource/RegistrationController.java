package com.bootcamp.microservicesmeetup.controller.resource;

import com.bootcamp.microservicesmeetup.controller.dto.RegistrationDTO;
import com.bootcamp.microservicesmeetup.model.etity.Registration;
import com.bootcamp.microservicesmeetup.service.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private RegistrationService registrationService;
    private ModelMapper modelMapper;

    public RegistrationController(RegistrationService registrationService, ModelMapper modelMapper) {
        this.registrationService = registrationService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegistrationDTO create(@RequestBody @Valid RegistrationDTO registrationDTO) {

        Registration entity = modelMapper.map(registrationDTO, Registration.class);
        entity = registrationService.save(entity);

        return modelMapper.map(entity, RegistrationDTO.class);
    }

}
