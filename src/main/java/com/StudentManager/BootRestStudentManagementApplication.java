package com.StudentManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.StudentManager.dao.UserDao;
import com.StudentManager.entities.User;

@SpringBootApplication
public class BootRestStudentManagementApplication implements CommandLineRunner{

	@Autowired
	private UserDao userDao;

	
	public static void main(String[] args) {
		SpringApplication.run(BootRestStudentManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1= new User();
		user1.setUserName("user1");
		user1.setActive(true);
		user1.setPassword(new BCryptPasswordEncoder().encode("abcd1234"));
		user1.setRoles("ROLE_USER");
		this.userDao.save(user1);
		
		User user2= new User();
		user2.setUserName("user2");
		user2.setActive(true);
		user2.setPassword(new BCryptPasswordEncoder().encode("abcd1234"));
		user2.setRoles("ROLE_USER");
		this.userDao.save(user2);
		
		User admin= new User();
		admin.setUserName("admin");
		admin.setActive(true);
		admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
		admin.setRoles("ROLE_ADMIN");
		this.userDao.save(admin);
	}

}
