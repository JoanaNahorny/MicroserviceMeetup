package com.bootcamp.microservicesmeetup.service.impl;

import com.bootcamp.microservicesmeetup.controller.dto.MeetupFilterDTO;
import com.bootcamp.microservicesmeetup.model.entity.Meetup;
import com.bootcamp.microservicesmeetup.model.entity.Registration;
import com.bootcamp.microservicesmeetup.service.MeetupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeetupServiceImpl implements MeetupService {
    @Override
    public Meetup save(Meetup meetup) {
        return null;
    }

    @Override
    public Optional<Meetup> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Meetup update(Meetup loan) {
        return null;
    }

    @Override
    public Page<Meetup> find(MeetupFilterDTO filterDTO, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Meetup> getRegistrationsByMeetup(Registration registration, Pageable pageable) {
        return null;
    }
}
