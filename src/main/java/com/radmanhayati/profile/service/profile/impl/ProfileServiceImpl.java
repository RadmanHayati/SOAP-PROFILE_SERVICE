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
import org.springframework.ws.soap.client.SoapFaultClientException;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileDao profileDao;
    private final UserSoapClient userSoapClient;
    private final UserServiceMapper mapper;

    @Override
    public ProfileResult createProfile(AddProfileModel model) throws UserNotFoundException {
        return getUserWithCheck(model.getUserId())
                .map(user -> {
                    var profile = mapper.toProfile(model);
                    return mapper.toProfileResult(profileDao.save(profile), user);
                })
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + model.getUserId()));
    }

    private Optional<GetUserResponse> getUserWithCheck(Long userId) {
        try {
            return Optional.of(userSoapClient.getUser(userId));
        } catch (SoapFaultClientException e) {
            if (e.getFaultStringOrReason().contains("User not found")) {
                return Optional.empty();
            } else {
                throw e;
            }
        }
    }
    @Override
    public ProfileResult getUser(Long userId) throws UserNotFoundException {
        return null;
    }

}
