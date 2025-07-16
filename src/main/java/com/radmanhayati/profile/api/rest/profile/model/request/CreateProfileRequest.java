package com.radmanhayati.profile.api.rest.profile.model.request;

import com.radmanhayati.profile.common.RequestService;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CreateProfileRequest extends RequestService {

    @NotBlank
    private Long userId;
    @NotBlank
    private String bio;
    @NotBlank
    private String location;
    @NotBlank
    private Integer age;

}
