package com.wolfcode.exceptions.validation.controller;

import com.wolfcode.exceptions.validation.dto.UserRequest;
import com.wolfcode.exceptions.validation.dto.UserResponse;
import com.wolfcode.exceptions.validation.entity.User;
import com.wolfcode.exceptions.validation.exception.UserNotFoundException;
import com.wolfcode.exceptions.validation.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<User> register(@Valid @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.register(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<User>> getById(@PathVariable("id") Long id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getById(id));
    }
}
