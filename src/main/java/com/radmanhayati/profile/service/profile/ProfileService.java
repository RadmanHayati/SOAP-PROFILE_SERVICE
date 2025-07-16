package com.radmanhayati.profile.service.profile;

import com.radmanhayati.profile.exception.UserNotFoundException;
import com.radmanhayati.profile.service.profile.model.AddProfileModel;
import com.radmanhayati.profile.service.profile.model.ProfileResult;

public interface ProfileService {
    ProfileResult createProfile(AddProfileModel model) throws UserNotFoundException;

    ProfileResult getUser(Long userId) throws UserNotFoundException;

}
