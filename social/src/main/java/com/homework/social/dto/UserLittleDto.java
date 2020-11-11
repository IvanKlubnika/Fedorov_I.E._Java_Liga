package com.homework.social.dto;

import lombok.*;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLittleDto {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Character sex;
}
