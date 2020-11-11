package com.homework.social.controller;

import com.homework.social.domain.User;
import com.homework.social.dto.MyPageDto;
import com.homework.social.dto.UserLittleDto;
import com.homework.social.dto.UserPageDto;
import com.homework.social.service.SocialService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class SocialController {

    private final SocialService socialService;

    /**
     * Метод для регистрации пользователя
     * @param user
     * @return
     */
    @PostMapping("registrationUser")
    public ResponseEntity registrationUser(@RequestBody @Valid UserPageDto user) {
        long id;
        id = socialService.registrationUser(user);
        String message = "id пользователя: " + id;
        return new ResponseEntity(message, HttpStatus.CREATED);
    }



    /**
     * Метод выводит страницу пользователя, в зависимости от того чья это страница
     * @param id
     * @param myId
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity userPage(@PathVariable Long id, @RequestParam Long myId){

       if (id.equals(myId)) {
           MyPageDto myPageDto = socialService.showMyPage(id);
           return new ResponseEntity(myPageDto, HttpStatus.OK);
       }

       else {
           UserPageDto userPageDto = socialService.showUserPage(id);
           return new ResponseEntity(userPageDto, HttpStatus.OK);
       }
    }



    /**
     * Метод для удаления страницы
     * @param myId
     * @return
     */
    @DeleteMapping("{myId}/delete")
    public HttpStatus deletePage(@PathVariable Long myId){
        socialService.deletePage(myId);
        return HttpStatus.OK;
    }



    /**
     * Метод для обновления информации пользователя
     * @param id
     * @param user
     * @return
     */
    @PatchMapping("{id}/edit")
    public ResponseEntity userUpdatePage(@PathVariable long id, @RequestBody @Valid UserPageDto user ){
        return new ResponseEntity(socialService.userUpdatePage(id, user), HttpStatus.OK);
    }



    /**
     * Метод для добавления друзей пользователя
     * @param myId
     * @param friendId
     * @return
     */
    @PutMapping("{myId}/add")
    public ResponseEntity addFriend(@PathVariable Long myId, @RequestParam Long friendId) {
        return new ResponseEntity(socialService.addFriend(myId, friendId), HttpStatus.CREATED);
    }



    /**
     * Метод для удаления друга
     * @param myId
     * @param friendId
     * @return
     */
    @DeleteMapping("{myId}/friends/delete")
    public ResponseEntity deleteFriend(@PathVariable Long myId, @RequestParam Long friendId){
        return new ResponseEntity(socialService.deleteFriend(myId, friendId), HttpStatus.OK);
    }



    /**
     * Метод для поиска друзей
     * @param search
     * @param pageable
     * @return
     */
    @GetMapping("search")
    public ResponseEntity searchFriend(@RequestParam(value = "search") String search, @PageableDefault(size = 5) Pageable pageable){
        Page<User> page = socialService.showUsers(search, pageable);
        return new ResponseEntity(page, HttpStatus.OK);
    }



    /**
     * Метод выводит друзей пользователя
     * @param myId
     * @return
     */
    @GetMapping("{myId}/friends")
    public ResponseEntity showFriends(@PathVariable Long myId){
     List<Long> list = socialService.showFriends(myId);
     return new ResponseEntity(list, HttpStatus.OK);
 }


}
