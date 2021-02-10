package com.asap.country_app.database.Functions;

import com.asap.country_app.database.user.User;
import com.asap.country_app.database.user.UserInfo;
import com.asap.country_app.dto.UserDto;
import com.asap.country_app.dto.UserInfoDto;

import java.util.function.Function;

import static com.asap.country_app.database.Functions.UserFunctions.userDTOToUser;
import static com.asap.country_app.database.Functions.UserFunctions.userToUserDTO;

public class UserInfoFunctions {

    public static final Function<UserInfo, UserDto> userInfoToUserInfoDTO = userInfo ->  new UserInfoDto(
            userInfo.getId(),
            userInfo.getNickName(),
            userInfo.getLastName(),
            userInfo.getName(),
            userInfo.getDateOfBirth(),
            userInfo.getCodeOfCountry(),
            userInfo.getCurrency(),
            userToUserDTO.apply(userInfo.getUser())
    );

    public static final Function<UserInfoDto,UserInfo> userInfoDTOToUserInfo = userInfoDto -> new UserInfo(
            userInfoDto.getNickName(),
            userInfoDto.getLastName(),
            userInfoDto.getName(),
            userInfoDto.getDateOfBirth(),
            userInfoDto.getCodeOfCountry(),
            userInfoDto.getCurrency(),
            userDTOToUser.apply(userInfoDto.getUserDto())
            );
}