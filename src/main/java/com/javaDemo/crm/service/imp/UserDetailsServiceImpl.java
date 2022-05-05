package com.javaDemo.crm.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.javaDemo.crm.dao.UserDao;
import com.javaDemo.crm.model.MyUserDetails;
import com.javaDemo.crm.model.User;

public class UserDetailsServiceImpl implements UserDetailsService {
	 
    @Autowired
    private UserDao userDao;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         return  new MyUserDetails(user);
               
    }
 
}
