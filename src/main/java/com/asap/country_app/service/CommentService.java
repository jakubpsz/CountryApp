package com.asap.country_app.service;

import com.asap.country_app.database.repository.CommentRepository;
import com.asap.country_app.database.user.Comment;
import com.asap.country_app.database.user.Location;
import com.asap.country_app.database.user.User;
import com.asap.country_app.database.user.UserInfo;
import com.asap.country_app.dto.CommentDto;
import com.asap.country_app.dto.UserDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.asap.country_app.database.Functions.CommentFunction.commentDTOToComment;
import static com.asap.country_app.database.Functions.CommentFunction.commentToCommentDTO;
import static com.asap.country_app.database.Functions.LocationFunctions.locationDTOToLocation;
import static com.asap.country_app.database.Functions.LocationFunctions.locationToLocationDTO;
import static com.asap.country_app.database.Functions.UserFunctions.userDTOToUserCreate;
import static com.asap.country_app.database.Functions.UserFunctions.userToUserDTOCreate;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Transactional
    public CommentDto addComment(CommentDto commentDto){
        Comment comment = new Comment(commentDto.getCreated(),commentDto.getText(),commentDto.getUser(),commentDto.getLocation());
        Comment savedComment = commentRepository.save(comment);
        return new CommentDto(savedComment.getId(),savedComment.getCreated(),savedComment.getText(),
                savedComment.getUser(),savedComment.getLocation());
    }

//    @Transactional
//    public UserDto saveUser(UserDto userDto) {
////TODO sprawdzenie wielkosci liter w mailu?
//        if (userRepository.findByEmail(userDto.getEmail()).isEmpty()) {
//            User user = userDTOToUserCreate.apply(userDto);
//            user.setUserInfo(new UserInfo());
//            log.info("User created: " + userDto.getEmail());
//            return userToUserDTOCreate.apply(userRepository.save(user));
//        } else {
//            log.info("This mail existed: " + userDto.getEmail());
//            return null;
//        }
//    }

//    private final LocationRepository locationRepository;
//
//    public LocationService(LocationRepository locationRepository) {
//        this.locationRepository = locationRepository;
//    }
//
//    @Transactional
//    public LocationDto saveLocation(LocationDto locationDto) {
//
//        Location location = locationRepository.findLocationByCountryAndCity(locationDto.getCountry(), locationDto.getCity());
//        if(location == null){
//            location = locationDTOToLocation.apply(locationDto);
//            log.info("Save Location");
//            return locationToLocationDTO.apply(locationRepository.save(location));
//        }else {
//            log.warn("Location existed early");
//            return locationDto;
//        }
//    }
//
//    @Transactional
//    public Location findByCountryAndCity(String country, String city){
//        return locationRepository.findLocationByCountryAndCity(country, city);
//    }

}
