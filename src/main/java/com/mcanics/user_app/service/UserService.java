package com.mcanics.user_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mcanics.user_app.data.models.User;
import com.mcanics.user_app.data.payloads.request.UserRequest;
import com.mcanics.user_app.data.payloads.response.MessageResponse;



@Component
public interface UserService {
	MessageResponse createUser(UserRequest userRequest);
	Optional<User>updateUser(Integer userId,UserRequest userRequest);
     void deleteUser(Integer userId);
    User getASingleUser(Integer userId);
    List<User>getAllUser();
}
