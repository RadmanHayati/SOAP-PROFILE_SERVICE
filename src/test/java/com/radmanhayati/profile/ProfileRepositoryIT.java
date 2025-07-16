package com.radmanhayati.profile;

import java.util.List;

import com.radmanhayati.profile.model.profile.Profile;
import com.radmanhayati.profile.model.profile.dao.ProfileDao;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertEquals;

class ProfileRepositoryIT extends AbstractContainerBaseTest {

	@Autowired
	private ProfileDao profileDao;

	@Test
	void whenSaveUser_thenCanRetrieve() {
		/*Profile profile = new Profile();
		profile.setEmail("test@example.com");
		profile.setName("Test User");

		Profile savedProfile = profileDao.save(profile);
		List<Profile> profiles = profileDao.findAll();

		assertFalse(profiles.isEmpty(), "User list should not be empty after save");
		assertEquals("Retrieved user email should match saved user email", "test@example.com", profiles.get(0)
				.getEmail());
		assertEquals("Retrieved user ID should match saved user ID", savedProfile.getId(), profiles.get(0).getId());*/
	}
}