package com.homework.social.service;


import com.homework.social.Filters.UserSpecificationsBuilder;
import com.homework.social.domain.User;
import com.homework.social.dto.MyPageDto;
import com.homework.social.dto.UserLittleDto;
import com.homework.social.dto.UserPageDto;
import com.homework.social.repository.SocialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class SocialService {

    private final SocialRepository socialRepository;

    /**
     * Метод для регистрации нового пользователя
     * Добавляет информацию о пользоваиеле в таблицу юзеров.
     * И добавляет пользователя в таблицу городов
     * @param userDto
     * @return
     */
    public long registrationUser(UserPageDto userDto) {
        User user = convertUserRegistDto(userDto);
        user = socialRepository.save(user);
        return user.getIdUser();
    }



    /**
     * Метод для добавления друзей пользователя.
     * В нем дважды вызывается метод socialRepository.addFriend, с измененой последовательностью параметров.
     * Для того чтобы добавить в базу данных друзей, обоим пользователям (Олесе Ваню и Ване Олесю)
     * @param myId
     * @param friendId
     * @return
     */
    public Integer addFriend (Long myId, Long friendId){
               socialRepository.addFriend(friendId, myId);
        return socialRepository.addFriend(myId, friendId);
    }



    /**
     * Метод выводит страницу пользователя (Свою)
     * @param userId
     * @return
     */
    public MyPageDto showMyPage(Long userId){
        User user = socialRepository.findById(userId).get();
        MyPageDto myPageDto = convertMyPageDto(user);
        return myPageDto;
    }



    /**
     *Метод выводит страницу пользователя(Другого пользователя)
     * @param userId
     * @return
     */
    public UserPageDto showUserPage(Long userId){
        User user = socialRepository.findById(userId).get();
        UserPageDto userPageDto = convertUserPageDto(user);
        return userPageDto;
    }



    /**
     * Метод для удаления своей страницы
     * @param myId
     * @return
     */
    public void deletePage (Long myId) {socialRepository.deleteById(myId);}



    /**
     * Метод для удаления друга
     * В нем дважды вызывается метод socialRepository.deleteFriend, с измененой последовательностью параметров.
     * Для того чтобы удалить из базы данных друзей, у обоих пользователей (у Олеси Ваню и у Вани Олесю)
     * @param myId
     * @param friendId
     * @return
     */
    public Integer deleteFriend (Long myId, Long friendId){
               socialRepository.deleteFriend(friendId, myId);
        return socialRepository.deleteFriend(myId, friendId);
    }



    /**
     * Метод дает обновить информацию о пользователе
     * @param userId
     * @param userPageDto
     * @return
     */
    public User userUpdatePage (Long userId, UserPageDto userPageDto){
        Optional<User> user = socialRepository.findById(userId);
        if (user.isPresent() == true){

            String st = userPageDto.getFirstName();
            if(st != null) user.get().setFirstName(st);

            st = userPageDto.getLastName();
            if(st != null) user.get().setLastName(st);

            st = userPageDto.getCity();
            if(st != null) user.get().setCity(st);

            st = userPageDto.getInterests();
            if(st != null) user.get().setInterests(st);

            char ch = userPageDto.getSex();
            if(st != null) user.get().setSex(ch);

            Integer in = userPageDto.getAge();
            if(in != null) user.get().setAge(in);

            return socialRepository.save(user.get());
        }
        return null;
    }



    /**
     * Метод выводит пользователей используя фильтр
     * @param search
     * @param pageable
     * @return
     */
    public Page<User> showUsers (String search, Pageable pageable) {
        UserSpecificationsBuilder builder = new UserSpecificationsBuilder();

        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");

        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<User> spec = builder.build();

        return socialRepository.findAll(spec, pageable);
    }


    /**
     * @param userId
     * @return
     */

    public List<Long> showFriends (Long userId){
        List<Long> listDto = socialRepository.showFriends(userId);
        return listDto;
    }




    /**
     *Метод выводит страницу пользователя в списке друзей
     * @param userId
     * @return
     */
    public UserLittleDto showUserPageInList(Long userId){
        User user = socialRepository.findById(userId).get();
        UserLittleDto userLittleDto = convertUserLittleDto(user);
        return userLittleDto;
    }







    /**
     * @param user
     * @return
     * Метод преобразовывает сущности юзер в UserLittleDto
     */
    public UserLittleDto convertUserLittleDto(User user){
        return UserLittleDto.builder()
                .sex(user.getSex())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    /**
     * @param user
     * @return
     * Метод преобразовывает сущности юзер в MyPageDto
     */
    public MyPageDto convertMyPageDto(User user){
        return MyPageDto.builder()
                .city(user.getCity())
                .sex(user.getSex())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .interests(user.getInterests())
                .build();
    }



    /**
     * @param user
     * @return
     * Метод преобразовывает сущности юзер в UserPageDto
     */
    public UserPageDto convertUserPageDto(User user){
        return UserPageDto.builder()
                .age(user.getAge())
                .city(user.getCity())
                .sex(user.getSex())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .interests(user.getInterests())
                .build();
    }


    /**
     * @param dto
     * @return
     * Метод преобразовывает UserRegistDto в сущность User
     */
    public User convertUserRegistDto(UserPageDto dto){

        return User.builder()
                .age(dto.getAge())
                .sex(dto.getSex())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .city(dto.getCity())
                .interests(dto.getInterests())
                .build();
    }







}
