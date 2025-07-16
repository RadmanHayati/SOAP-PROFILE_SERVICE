package com.radmanhayati.profile.service.profile.mapper;

import com.radmanhayati.profile.model.profile.Profile;
import com.radmanhayati.profile.service.profile.model.AddProfileModel;
import com.radmanhayati.profile.service.profile.model.ProfileInfo;
import com.radmanhayati.profile.service.profile.model.ProfileResult;
import com.radmanhayati.profile.soap.generated.GetUserResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserServiceMapper {

    @Mapping(target = "profile",expression = "java(toProfileInfo(profile,response))")
    ProfileResult toProfileResult(Profile profile,GetUserResponse response);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "age", source = "profile.age")
    @Mapping(target = "location", source = "profile.location")
    @Mapping(target = "bio", source = "profile.bio")
    @Mapping(target = "userId", source = "profile.userId")
    @Mapping(target = "userName", source = "response.user.name")
    @Mapping(target = "userEmail", source = "response.user.email")
    ProfileInfo toProfileInfo(Profile profile, GetUserResponse response);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "age", source = "age")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "bio", source = "bio")
    @Mapping(target = "userId", source = "userId")
    Profile toProfile(AddProfileModel model);

}
