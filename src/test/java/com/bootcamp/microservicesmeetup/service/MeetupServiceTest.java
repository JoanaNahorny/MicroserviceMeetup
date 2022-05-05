package com.bootcamp.microservicesmeetup.service;

import com.bootcamp.microservicesmeetup.exception.BusinessException;
import com.bootcamp.microservicesmeetup.model.entity.Meetup;
import com.bootcamp.microservicesmeetup.repository.MeetupRepository;
import com.bootcamp.microservicesmeetup.service.impl.MeetupServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class MeetupServiceTest {

    MeetupService meetupService;

    @MockBean
    MeetupRepository repository;

    @BeforeEach
    public void setUp() {
        this.meetupService = new MeetupServiceImpl(repository);
    }

    @Test
    @DisplayName("Should save an meetup")
    public void saveMeetupTest() {

        Meetup meetup = createValidMeetup();

        Mockito.when(repository.existsByEvent(Mockito.anyString())).thenReturn(false);
        Mockito.when(repository.save(meetup)).thenReturn(createValidMeetup());

        Meetup savedMeetup = meetupService.save(meetup);

        assertThat(savedMeetup.getId()).isEqualTo(108);
        assertThat(savedMeetup.getEvent()).isEqualTo("Palestra");
        assertThat(savedMeetup.getMeetupDate()).isEqualTo("13/10/2022");
    }

    @Test
    @DisplayName("Should get an meetup by Id")
    public void getMeetupByIdTest() {

        Integer id = 200;
        Meetup meetup = createValidMeetup();
        meetup.setId(id);
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(meetup));

        Optional<Meetup> foundMeetup = meetupService.getById(id);

        assertThat(foundMeetup.isPresent()).isTrue();
        assertThat(foundMeetup.get().getId()).isEqualTo(id);
        assertThat(foundMeetup.get().getEvent()).isEqualTo(meetup.getEvent());
        assertThat(foundMeetup.get().getMeetupDate()).isEqualTo(meetup.getMeetupDate());
    }

    @Test
    @DisplayName("Should delete an meetup")
    public void deleteMeetupTest() {

        Meetup meetup = Meetup.builder().id(100).build();

        assertDoesNotThrow(() -> meetupService.delete(meetup));

        Mockito.verify(repository, Mockito.times(1)).delete(meetup);
    }

    @Test
    @DisplayName("Should update an meetup")
    public void updateMeetupTest(){

        Integer id = 101;
        Meetup updatingMeetup = Meetup.builder().id(101).build();

        Meetup updatedMeetup = createValidMeetup();
        updatedMeetup.setId(id);

        Mockito.when(repository.save(updatingMeetup)).thenReturn(updatedMeetup);
        Meetup meetup = meetupService.update(updatingMeetup);

        assertThat(meetup.getId()).isEqualTo(updatedMeetup.getId());
        assertThat(meetup.getEvent()).isEqualTo(updatedMeetup.getEvent());
        assertThat(meetup.getMeetupDate()).isEqualTo(updatedMeetup.getMeetupDate());
    }

    private Meetup createValidMeetup() {
        return Meetup.builder()
                .id(108)
                .event("Palestra")
                .meetupDate("13/10/2022")
                .build();
    }


}
