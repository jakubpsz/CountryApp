package com.asap.country_app.database.Functions;

import com.asap.country_app.database.user.UserInfo;
import com.asap.country_app.dto.UserInfoDto;

import java.util.function.Function;

import static com.asap.country_app.database.Functions.UserFunctions.userToUserDTOCreate;

public class UserInfoFunctions {

    public static final Function<UserInfo, UserInfoDto> userInfoToUserInfoDTO = userInfo ->  new UserInfoDto(
            userInfo.getId(),
            userInfo.getNickName(),
            userInfo.getLastName(),
            userInfo.getName(),
            userInfo.getDateOfBirth(),
            userInfo.getCodeOfCountry(),
            userInfo.getCurrency(),
            userToUserDTOCreate.apply(userInfo.getUser())
    );

    public static final Function<UserInfoDto,UserInfo> userInfoDTOToUserInfo = userInfoDto -> new UserInfo(
            userInfoDto.getNickName(),
            userInfoDto.getLastName(),
            userInfoDto.getName(),
            userInfoDto.getDateOfBirth(),
            userInfoDto.getCodeOfCountry(),
            userInfoDto.getCurrency()
            );
}