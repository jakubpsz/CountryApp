package com.asap.country_app.dto;

import com.asap.country_app.database.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

    private UUID id;

    private String nickName;
    private String name;
    private String lastName;
    private String dateOfBirth;
    private String codeOfCountry;
    private String currency;

    private UserDto user;

    public UserInfoDto(String nickName, String name, String lastName, String dateOfBirth, String codeOfCountry, String currency, UserDto user) {
        this.nickName = nickName;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.codeOfCountry = codeOfCountry;
        this.currency = currency;
        this.user = user;
    }
}
