package com.homework.social.Service;

import com.homework.social.Filters.UserSpecificationsBuilder;
import com.homework.social.controller.SocialController;
import com.homework.social.domain.User;
import com.homework.social.dto.MyPageDto;
import com.homework.social.dto.UserPageDto;
import com.homework.social.repository.SocialRepository;
import com.homework.social.service.SocialService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

public class UnitTestSocialService {

    @Mock
    private SocialRepository socialRepository;

    private SocialService socialService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        this.socialService = new SocialService(socialRepository);
    }


    @Test
    public void registrationUserTest() {
        User user = new User();
        when(socialRepository.save(user)).thenReturn(any(User.class));

        socialRepository.save(user);
        Mockito.verify(socialRepository).save(any(User.class));
        verifyNoMoreInteractions(socialService);
    }


    @Test
    public void addFriendTest (){
        when(socialRepository.addFriend(1, 2)).thenReturn(1);

        socialRepository.addFriend(3,2);
        Mockito.verify(socialRepository).addFriend(3,2);
        verifyNoMoreInteractions(socialService);
    }


    @Test
    public void showMyPageTest(){
        when(socialRepository.findById(1L)).thenReturn(any());

        socialRepository.findById(3L);
        Mockito.verify(socialRepository).findById(3L);
        verifyNoMoreInteractions(socialService);
    }


    @Test
    public void showUserPageTest(){
        when(socialRepository.findById(1L)).thenReturn(any());

        socialRepository.findById(3L);
        Mockito.verify(socialRepository).findById(3L);
        verifyNoMoreInteractions(socialService);
    }


    @Test
    public void deletePage () {
        socialRepository.deleteById(1L);
        verify(socialRepository).deleteById(1L);
        verifyNoMoreInteractions(socialService);
    }


    @Test
    public void deleteFriendTest (){
        when(socialRepository.deleteFriend(1L, 3L)).thenReturn(1);
        socialRepository.deleteFriend(1L, 2L);
        verify(socialRepository).deleteFriend(1L, 2L);
        verifyNoMoreInteractions(socialService);
    }


    @Test
    public void userUpdatePageTest (){
        socialRepository.findById(anyLong());
        verify(socialRepository).findById(anyLong());
        verifyNoMoreInteractions(socialService);
    }


    @Test
    public void showUsersTest () {
        UserSpecificationsBuilder builder = new UserSpecificationsBuilder();


        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher("age:7" + ",");

        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<User> spec = builder.build();

        socialRepository.findAll(any(Specification.class), any(Pageable.class));
        verify(socialRepository).findAll(any(Specification.class), any(Pageable.class));


    }

}
