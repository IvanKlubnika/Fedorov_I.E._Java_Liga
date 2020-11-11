package com.homework.social.Controller;

import com.homework.social.controller.SocialController;
import com.homework.social.domain.User;
import com.homework.social.dto.MyPageDto;
import com.homework.social.dto.UserPageDto;
import com.homework.social.service.SocialService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.*;


public class UnitTestSocialController {

    @Mock
    private SocialService socialService;

    private SocialController socialController;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        this.socialController = new SocialController(socialService);
    }

    @Test
    public void registrationUserTest() throws Exception {
        //Проверяем что возвращает метод
        long id = 1;
        when(socialService.registrationUser(Mockito.any(UserPageDto.class))).thenReturn(id);

        //Проверяем сколько раз был вызван метод
        socialService.registrationUser(any(UserPageDto.class));
        verify(socialService).registrationUser(any());
        verifyNoMoreInteractions(socialService);
    }

//
    @Test
    public void userPageTest(){
        //Проверяем что возвращает метод
        when(socialService.showMyPage(anyLong())).thenReturn(any(MyPageDto.class));
    }


    @Test
    public void deletePageTest(){
        //Проверяем сколько раз был вызван метод
        socialService.deletePage(anyLong());
        verify(socialService).deletePage(anyLong());
        verifyNoMoreInteractions(socialService);
    }

//
    @Test
    public void userUpdatePageTest(){
        //Проверяем что возвращает метод
        Mockito.when(socialService.userUpdatePage(anyLong(), any(UserPageDto.class))).thenReturn(User.builder().build());

       //Проверяем сколько раз был вызван метод
        socialService.userUpdatePage(anyLong(), any(UserPageDto.class));
        verify(socialService).userUpdatePage(anyLong(), any(UserPageDto.class));
        verifyNoMoreInteractions(socialService);
    }


    @Test
    public void addFriendTest() {
        //Проверяем что возвращает метод
        Mockito.when(socialService.addFriend(anyLong(), anyLong())).thenReturn(1);

        //Проверяем сколько раз был вызван метод
        socialService.addFriend(anyLong(), anyLong());
        verify(socialService).addFriend(anyLong(), anyLong());
        verifyNoMoreInteractions(socialService);
    }

    @Test
    public void deleteFriendTest(){
        //Проверяем что возвращает метод
        Mockito.when(socialService.deleteFriend(anyLong(), anyLong())).thenReturn(1);

        //Проверяем сколько раз был вызван метод
        socialService.deleteFriend(anyLong(), anyLong());
        verify(socialService).deleteFriend(anyLong(), anyLong());
        verifyNoMoreInteractions(socialService);
    }

    @Test
    public void searchFriendTest(){
        //Проверяем что возвращает метод
        Page<User> page = socialService.showUsers(anyString(), any(Pageable.class));
        Mockito.when(socialService.showUsers(anyString(), any(Pageable.class))).thenReturn(page);

        //Проверяем сколько раз был вызван метод
        verify(socialService).showUsers(anyString(), any(Pageable.class));
        verifyNoMoreInteractions(socialService);
    }
}
