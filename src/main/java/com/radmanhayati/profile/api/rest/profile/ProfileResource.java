package com.radmanhayati.profile.api.rest.profile;


import com.radmanhayati.profile.api.rest.profile.mapper.ProfileResourceMapper;
import com.radmanhayati.profile.api.rest.profile.model.request.CreateProfileRequest;
import com.radmanhayati.profile.api.rest.profile.model.response.UserProfileResponse;
import com.radmanhayati.profile.exception.UserNotFoundException;
import com.radmanhayati.profile.service.profile.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileResource {

    private final ProfileService service;

    private final ProfileResourceMapper mapper;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserProfileResponse createProfile(@Valid @RequestBody CreateProfileRequest request) throws UserNotFoundException {
        var result = service.createProfile(mapper.toCreateProfilerModel(request));
        return mapper.toUserResponse(result);
    }
/*
    @GetMapping("/{userId}")
    public UserProfileResponse getProfile(@PathVariable Long userId) {
        return service.getUserProfile(userId);
    }*/

}
