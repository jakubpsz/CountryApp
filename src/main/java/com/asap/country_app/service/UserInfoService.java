package com.asap.country_app.service;

import com.asap.country_app.database.repository.UserInfoRepository;
import com.asap.country_app.database.repository.UserRepository;
import com.asap.country_app.database.model.AppUser;
import com.asap.country_app.database.model.UserInfo;
import com.asap.country_app.dto.UserInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

import static com.asap.country_app.database.Functions.UserInfoFunctions.userInfoDTOToUserInfo;
import static com.asap.country_app.database.Functions.UserInfoFunctions.userInfoToUserInfoDTO;

@Service
@Slf4j
public class UserInfoService {
    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;

    public UserInfoService(UserRepository userRepository, UserInfoRepository userInfoRepository) {
        this.userRepository = userRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Transactional
    public UserInfoDto editUserInfo(UserInfoDto userInfoDto, UUID userId){
        AppUser user = userRepository.findById(userId).orElseThrow();
        UserInfo old = user.getUserInfo();
        user.setUserInfo(userInfoDTOToUserInfo.apply(userInfoDto));
        userInfoRepository.delete(old);
        log.info("UserInfo for " + user.getEmail() + " " + user.getId() + " is changed: " + user.getUserInfo());
        return userInfoToUserInfoDTO.apply(userRepository.save(user).getUserInfo());
    }

    @Transactional
    public UserInfoDto getUserInfo(UUID userId){
        AppUser user = userRepository.findById(userId).orElseThrow();
        return userInfoToUserInfoDTO.apply(user.getUserInfo());
    }
}
