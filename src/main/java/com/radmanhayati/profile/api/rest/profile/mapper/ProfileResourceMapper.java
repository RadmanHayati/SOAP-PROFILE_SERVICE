package com.radmanhayati.profile.api.rest.profile.mapper;

import com.radmanhayati.profile.api.rest.profile.model.request.CreateProfileRequest;
import com.radmanhayati.profile.api.rest.profile.model.response.UserProfileResponse;
import com.radmanhayati.profile.common.ResultStatus;
import com.radmanhayati.profile.service.profile.model.AddProfileModel;
import com.radmanhayati.profile.service.profile.model.ProfileResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { ResultStatus.class })
public interface ProfileResourceMapper {

	@Mapping(target = "profile", source = "profile")
	@Mapping(target = "result", expression = "java(ResultStatus.SUCCESS)")
	UserProfileResponse toUserResponse(ProfileResult result);

	@Mapping(target = "userId", source = "userId")
	@Mapping(target = "bio", source = "bio")
	@Mapping(target = "location", source = "location")
	@Mapping(target = "age", source = "age")
	AddProfileModel toCreateProfilerModel(CreateProfileRequest request);
}
