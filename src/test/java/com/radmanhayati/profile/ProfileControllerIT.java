package com.radmanhayati.profile;

import com.radmanhayati.profile.api.rest.profile.model.request.CreateProfileRequest;
import com.radmanhayati.profile.api.rest.profile.model.response.UserProfileResponse;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ProfileControllerIT extends AbstractContainerBaseTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void whenCreateProfile_thenReturns201() {
		CreateProfileRequest request = new CreateProfileRequest();
		request.setUserId(1L);
		request.setBio("Test Bio");
		request.setLocation("Test Location");
		request.setAge(18);

		ResponseEntity<UserProfileResponse> response = restTemplate.postForEntity(
				"/api/profiles",
				new HttpEntity<>(request),
				UserProfileResponse.class
		);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("john.doe@example.com", response.getBody().getProfile().getUserEmail());
		assertEquals("John Doe", response.getBody().getProfile().getUserName());
		assertEquals("Test Bio", response.getBody().getProfile().getBio());
	}
}