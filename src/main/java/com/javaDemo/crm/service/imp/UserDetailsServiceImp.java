package com.javaDemo.crm.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaDemo.crm.dao.UserDao;
import com.javaDemo.crm.model.MyUserDetails;
import com.javaDemo.crm.model.User;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	
	public String getCurrentUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			return username;
		} else {
			String username = principal.toString();
			return username;

		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new MyUserDetails(user);

	}

}
