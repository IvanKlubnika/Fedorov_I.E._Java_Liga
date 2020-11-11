package com.homework.social.dto;

/*
    Dto для отображения на странице пользователя
 */

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPageDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Max(200)
    private Integer age;

    @NotNull
    private Character sex;

    private String interests;

    private String city;
}