package com.radmanhayati.profile.service.profile.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProfileInfo {

    private Long userId;
    private String userName;
    private String userEmail;
    private String bio;
    private String location;
    private Integer age;

}
