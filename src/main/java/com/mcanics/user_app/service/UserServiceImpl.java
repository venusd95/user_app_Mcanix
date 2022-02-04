package com.mcanics.user_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcanics.user_app.data.models.User;
import com.mcanics.user_app.data.payloads.request.UserRequest;
import com.mcanics.user_app.data.payloads.response.MessageResponse;
import com.mcanics.user_app.data.repository.UserRepository;
import com.mcanics.user_app.exception.ResourceNotFoundException;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Override
	public MessageResponse createUser(UserRequest userRequest) {
		User newUser=new User();
		 newUser.setFirstName(userRequest.getFirstName());
	       newUser.setLastName(userRequest.getLastName());
	       newUser.setEmail(userRequest.getEmail());
	       newUser.setPassword(userRequest.getPassword());
	       newUser.setAdharNumber(userRequest.getAdharNumber());
	       newUser.setMobileNumber(userRequest.getMobileNumber());
	       
	        userRepository.save(newUser);
	        return new MessageResponse("New User created successfully");


	}

	@Override
	public Optional<User> updateUser(Integer userId, UserRequest userRequest) {
		Optional<User> user = userRepository.findById(userId);
        if (user==null){
        throw new ResourceNotFoundException("User", "id", userId);
        }
        else
        user.get().setFirstName(userRequest.getFirstName());
        user.get().setLastName(userRequest.getLastName());
        user.get().setEmail(userRequest.getEmail());
        user.get().setPassword(userRequest.getPassword());
        user.get().setMobileNumber(userRequest.getMobileNumber());
        user.get().setAdharNumber(userRequest.getAdharNumber());

        userRepository.save(user.get());
        return user;

	}

	@Override
	public void deleteUser(Integer userId) {
		if (userRepository.getById(userId).getId().equals(userId)){
            userRepository.deleteById(userId);
        }
        else throw new ResourceNotFoundException("User", "id", userId);
		
	}

	@Override
	public User getASingleUser(Integer userId) {
		return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

}
