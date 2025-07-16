package com.radmanhayati.profile;

import org.springframework.boot.SpringApplication;

public class TestUserApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProfileApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
