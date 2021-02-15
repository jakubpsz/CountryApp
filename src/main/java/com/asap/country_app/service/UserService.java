package com.asap.country_app.service;

import com.asap.country_app.database.errors.UserNotFoundException;
import com.asap.country_app.database.repository.UserInfoRepository;
import com.asap.country_app.database.repository.UserRepository;
import com.asap.country_app.database.user.Location;
import com.asap.country_app.database.user.User;
import com.asap.country_app.database.user.UserInfo;
import com.asap.country_app.dto.LocationDto;
import com.asap.country_app.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

import static com.asap.country_app.database.Functions.LocationFunctions.locationDTOToLocation;
import static com.asap.country_app.database.Functions.UserFunctions.userDTOToUserCreate;
import static com.asap.country_app.database.Functions.UserFunctions.userToUserDTO;
import static com.asap.country_app.database.Functions.UserFunctions.userToUserDTOCreate;


@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserInfoRepository userInfoR;
    private final LocationService locationService;

    public UserService(UserRepository userRepository, UserInfoRepository userInfoR, LocationService locationService) {
        this.userRepository = userRepository;
        this.userInfoR = userInfoR;
        this.locationService = locationService;
    }

    @Transactional
    public UserDto saveUser(UserDto userDto) {
//TODO sprawdzenie wielkosci liter w mailu?
        if (userRepository.findByEmail(userDto.getEmail()).isEmpty()) {
            User user = userDTOToUserCreate.apply(userDto);
            user.setUserInfo(new UserInfo());
            log.info("User created: " + userDto.getEmail());
            return userToUserDTOCreate.apply(userRepository.save(user));
        } else {
            log.info("This mail existed: " + userDto.getEmail());
            return null;
        }
    }

//    @Transactional
//    public UserInfoDto editUserInfo(UserDto userDto) {
//
//        User user = userRepository.findByEmail(userDto.getEmail()).orElseGet(null);
//        if (user.getUserInfo() == null) {
//            user.setUserInfo(userInfoDTOToUserInfo.apply(userDto.getUserInfoDto()));
//            user = userRepository.save(user);
//        } else {
//            UserInfo userInfoId = user.getUserInfo();
//            user.setUserInfo(userInfoDTOToUserInfo.apply(userDto.getUserInfoDto()));
//            user = userRepository.save(user);
//            userInfoR.delete(userInfoId);
//        }
//        log.info("UserInfo for " + user.getEmail() + user.getId() + " is changed: " + user.getUserInfo());
//        return userInfoToUserInfoDTO.apply(user.getUserInfo());
//    }


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

    @Transactional
    public boolean addLikedLocation(LocationDto locationDto, UUID userId) {

        Location location = locationService.findByCountryAndCity(locationDto.getCountry(), locationDto.getCity());
        User user = userRepository.findById(userId).orElseGet(null);

        List<Location> list = user.getLikedLocations();
        changeLocationStatus(locationDto, userId, location, list);

        user.setLikedLocations(list);
        userRepository.save(user);

        return true;
    }

    @Transactional
    public boolean addVisitedLocation(LocationDto locationDto, UUID userId) {

        Location location = locationService.findByCountryAndCity(locationDto.getCountry(), locationDto.getCity());
        User user = userRepository.findById(userId).orElseGet(null);

        List<Location> list = user.getVisitedLocations();
        changeLocationStatus(locationDto, userId, location, list);

        user.setVisitedLocations(list);
        userRepository.save(user);
        return true;
    }

    private void changeLocationStatus(LocationDto locationDto, UUID userId, Location location, List<Location> list) {
        if(location == null){
            location = locationDTOToLocation.apply(locationDto);
        }
        if (list.contains(location)){
            list.remove(location);
            log.info("User {} remove visited {}", userId, locationDto.getCity());
        } else {
            list.add(location);
            log.info("User {} add visited {}", userId, locationDto.getCity());
        }
    }

    @Transactional
    public boolean addWantToVisitLocation(LocationDto locationDto, UUID userId) {

        Location location = locationService.findByCountryAndCity(locationDto.getCountry(), locationDto.getCity());
        User user = userRepository.findById(userId).orElseGet(null);

        List<Location> list = user.getLocationsWantedToVisit();
        changeLocationStatus(locationDto, userId, location, list);

        user.setLocationsWantedToVisit(list);
        userRepository.save(user);
        return true;
    }


    public UserDto getUser(UUID userId) {
        return userToUserDTO.apply(userRepository.findById(userId).orElseThrow());
    }
}
