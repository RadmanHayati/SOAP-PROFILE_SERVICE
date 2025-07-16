package com.radmanhayati.profile.service.profile.impl;

import com.radmanhayati.profile.client.UserSoapClient;
import com.radmanhayati.profile.exception.UserNotFoundException;
import com.radmanhayati.profile.model.profile.dao.ProfileDao;
import com.radmanhayati.profile.service.profile.ProfileService;
import com.radmanhayati.profile.service.profile.mapper.UserServiceMapper;
import com.radmanhayati.profile.service.profile.model.AddProfileModel;
import com.radmanhayati.profile.service.profile.model.ProfileResult;
import com.radmanhayati.profile.soap.generated.GetUserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileDao profileDao;
    private final UserSoapClient userSoapClient;
    private final UserServiceMapper mapper;

    @Override
    public ProfileResult createProfile(AddProfileModel model) throws UserNotFoundException {
        GetUserResponse response = userSoapClient.getUser(model.getUserId());
        if (response.getUser() == null) {
            throw new UserNotFoundException("User not found");
        }
        var profile = mapper.toProfile(model);
        return mapper.toProfileResult(profileDao.save(profile));
    }

    @Override
    public ProfileResult getUser(Long userId) throws UserNotFoundException {
        return null;
    }

}
