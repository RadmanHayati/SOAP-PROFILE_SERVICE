package com.radmanhayati.profile.api.rest.profile.model.response;

import com.radmanhayati.profile.common.ResponseService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class UserProfileResponse extends ResponseService {
	private ProfileDto profile;
}
