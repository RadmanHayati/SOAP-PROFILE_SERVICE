package com.radmanhayati.profile.api.rest.profile.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfileDto {
    private Long userId;
    private String userName;
    private String userEmail;
    private String bio;
    private String location;
    private Integer age;
}
