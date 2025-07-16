package com.radmanhayati.profile.model.profile.dao;


import com.radmanhayati.profile.model.profile.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileDao extends JpaRepository<Profile, Long> {

}
