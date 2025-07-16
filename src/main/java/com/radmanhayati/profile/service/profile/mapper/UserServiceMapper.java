package com.radmanhayati.profile.service.profile.mapper;

import com.radmanhayati.profile.model.profile.Profile;
import com.radmanhayati.profile.service.profile.model.AddProfileModel;
import com.radmanhayati.profile.service.profile.model.ProfileInfo;
import com.radmanhayati.profile.service.profile.model.ProfileResult;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserServiceMapper {

    @Mapping(target = "profile", source = "profile")
    ProfileResult toProfileResult(Profile profile);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "age", source = "age")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "bio", source = "bio")
    @Mapping(target = "userId", source = "userId")
    ProfileInfo toProfileInfo(Profile profile);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "age", source = "age")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "bio", source = "bio")
    @Mapping(target = "userId", source = "userId")
    Profile toProfile(AddProfileModel model);

}
