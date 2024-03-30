package com.wolfcode.exceptions.validation.service;

import com.wolfcode.exceptions.validation.dto.UserRequest;
import com.wolfcode.exceptions.validation.dto.UserResponse;
import com.wolfcode.exceptions.validation.entity.User;
import com.wolfcode.exceptions.validation.exception.UserNotFoundException;
import com.wolfcode.exceptions.validation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;


    public User register(UserRequest userRequest) {
        User user = User.builder()
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.getLastname())
                .email(userRequest.getEmail())
                .phone(254 + userRequest.getPhone())
                .dateOfBirth(userRequest.getDateOfBirth())
                .nationality(userRequest.getNationality().toUpperCase())
                .levelOfStudy(userRequest.getLevelOfStudy())
                .build();
        repository.save(user);
        return user;
    }

    public List<UserResponse> getAllUsers() {
        List<User> user = repository.findAll();
        return user.stream().map(users -> mapToResponse(users)).collect(Collectors.toList());
    }

    private UserResponse mapToResponse(User users) {
        return UserResponse.builder()
                .firstname(users.getFirstname())
                .lastname(users.getLastname())
                .phone(users.getPhone())
                .email(users.getEmail())
                .dateOfBirth(users.getDateOfBirth())
                .nationality(users.getNationality())
                .build();
    }

    public Optional<User> getById(Long id) throws UserNotFoundException {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("user not found with id: " + id);
        } else {
            return user;
        }
    }
}
