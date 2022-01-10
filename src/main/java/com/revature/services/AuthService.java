package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.DAOs.UserDao;
import com.revature.services.AuthPrincipal;

@SuppressWarnings("unused")
@Service
public class AuthService implements UserDetailsService {

	@Autowired
    private UserDao userRepository;
//This service loads in User information from Database and checks user information received from front end to see if information matches.
    @Override
    public UserDetails loadUserByUsername(String username) {
    	System.out.println("We have reached load User by Username");
    	List<User> users = userRepository.findUserByUsername(username);
        User user = users.get(0);        
       
        System.out.println("Found user by username: " + user);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        AuthPrincipal ap = new AuthPrincipal(user);
        System.out.println(ap);
        return ap;
    }
  

}
