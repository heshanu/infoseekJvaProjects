package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.enitity.Gender;
import com.example.demo.enitity.Users;
import com.example.demo.enitity.UsersProfile;
import com.example.demo.repository.UsersProfileRepository;
import com.example.demo.repository.UsersRepository;

@SpringBootApplication
public class SpringJpaOnetoOneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOnetoOneApplication.class, args);
	}

	// inject
	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private UsersProfileRepository userprofilerepository;

	@Override
	public void run(String... args) throws Exception {

		// user obj
		Users users = new Users();
		users.setName("heshan");
		users.setEmail("heshan@gmail.com");

		UsersProfile usersprofile = new UsersProfile();
		usersprofile.setAddress("hikka");
		usersprofile.setBirthOfDate(LocalDate.of(2020, 10, 21));
		usersprofile.setPhoneNumber("11112");
		usersprofile.setGender(Gender.MALE);
		usersprofile.setPhoneNumber("11112");

		// because this is bidirectional
		users.setUserProfile(usersprofile);
		usersprofile.setUsers(users);

		userRepository.save(users);
	}

}
