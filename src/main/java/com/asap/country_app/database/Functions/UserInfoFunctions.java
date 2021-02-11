package com.asap.country_app.database.Functions;

import com.asap.country_app.database.user.UserInfo;
import com.asap.country_app.dto.UserInfoDto;

import java.util.function.Function;

public class UserInfoFunctions {

//    private UserRepository userRepository;
//
//    public UserInfoFunctions(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public static final Function<UserInfo, UserInfoDto> userInfoToUserInfoDTO = userInfo -> new UserInfoDto(
            userInfo.getId(),
            userInfo.getNickName(),
            userInfo.getLastName(),
            userInfo.getName(),
            userInfo.getDateOfBirth(),
            userInfo.getCodeOfCountry(),
            userInfo.getCurrency()
    );

    public static final Function<UserInfoDto, UserInfo> userInfoDTOToUserInfo = userInfoDto -> new UserInfo(
            userInfoDto.getNickName(),
            userInfoDto.getLastName(),
            userInfoDto.getName(),
            userInfoDto.getDateOfBirth(),
            userInfoDto.getCodeOfCountry(),
            userInfoDto.getCurrency()
//            userRepository.findByEmail(userInfoDto.getUserDto().getEmail()).get()
    );
}