package com.StudentManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.StudentManager.dao.CustomUserDetail;
import com.StudentManager.dao.UserDao;
import com.StudentManager.entities.User;

/*This class must return and object of UserDetails and not User ,Hence we Create a class "CustomUserDetails"
 *which implements UserDetails and use its Constructor to convert User to user details*/

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=this.userDao.findByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new CustomUserDetail(user);	//
	}

}
