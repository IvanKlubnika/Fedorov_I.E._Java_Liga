package com.homework.social.dto;


import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Max;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyPageDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Character sex;

    private String interests;

    private String city;
}
