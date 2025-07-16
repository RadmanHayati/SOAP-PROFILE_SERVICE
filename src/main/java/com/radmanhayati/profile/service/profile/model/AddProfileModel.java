package com.radmanhayati.profile.service.profile.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddProfileModel {

	private Long userId;

	private String bio;

	private String location;

	private Integer age;
}
