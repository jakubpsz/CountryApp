package com.asap.country_app.service;

import com.asap.country_app.database.errors.UserNotFoundException;
import com.asap.country_app.database.repository.UserRepository;
import com.asap.country_app.database.user.User;
import com.asap.country_app.dto.UserDto;
import com.asap.country_app.dto.UserInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

import static com.asap.country_app.database.Functions.UserFunctions.userDTOToUserCreate;
import static com.asap.country_app.database.Functions.UserFunctions.userToUserDTOCreate;
import static com.asap.country_app.database.Functions.UserInfoFunctions.userInfoDTOToUserInfo;
import static com.asap.country_app.database.Functions.UserInfoFunctions.userInfoToUserInfoDTO;


@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDto saveUser(UserDto userDto) {

        if (userRepository.findByEmail(userDto.getEmail()).isEmpty()) {
            User user = userDTOToUserCreate.apply(userDto);
            log.info("User created: " + userDto.getEmail());
            return userToUserDTOCreate.apply(userRepository.save(user));
        } else {
            log.info("This mail existed: " + userDto.getEmail());
            return null;
        }
    }

    @Transactional
    public UserInfoDto editUserInfo(UserDto userDto) {

        User user = userRepository.findByEmail(userDto.getEmail()).get();
        user.setUserInfo(userInfoDTOToUserInfo.apply(userDto.getUserInfoDto()));
        log.info("UserInfo for " + user + " is changed: " + user.getUserInfo());

        return userInfoToUserInfoDTO.apply(user.getUserInfo());


    }


    //1. pobrac adres jesli istnieje
    //2. dopisac adres do osoby
    //3. zapisa0107  osobe

//    @Transactional
//    public UserDto findById(UUID id) throws UserNotFoundException {
//        return
//        userRepository.findById(id).map(userToUserDTO).orElseThrow(PersonNotFoundException::new);
//    }

//    @Transactional
//    public PersonDto editPerson(UUID id, PersonDto personDto) throws PersonNotFoundException {
//
//        return personRepository.findById(id).map(person -> {
//            person.setGender(personDto.getGender());
//            person.setLastName(personDto.getLastName());
//            person.setName(personDto.getName());
//            person.setPesel(personDto.getPesel());
//            return personRepository.save(person);
//        })
//                .map(personToPersonDTO)
//                .orElseThrow(PersonNotFoundException::new);
//    }

    @Transactional
    public void deleteUser(UUID id) throws UserNotFoundException {

        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }


}