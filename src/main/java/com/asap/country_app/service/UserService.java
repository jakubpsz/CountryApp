package com.asap.country_app.service;

import com.asap.country_app.database.errors.UserNotFoundException;
import com.asap.country_app.database.repository.UserRepository;
import com.asap.country_app.database.user.User;
import com.asap.country_app.dto.UserDto;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDto savePerson(UserDto personDto){

        //1. pobrac adres jesli istnieje
        //2. dopisac adres do osoby
        //3. zapisa0107  osobe

        User user = user.apply(personDto);
        user = userRepository.save(person);
        return personToPersonDTO.apply(person);
    }


//    @Transactional
//    public UserDto findById(UUID id) throws UserNotFoundException {
//        return userRepository.findById(id).map(userToUserDTO).orElseThrow(PersonNotFoundException::new);
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
    public void deleteUser (UUID id) throws UserNotFoundException {

        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }

}