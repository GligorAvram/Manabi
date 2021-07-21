package ro.manabi.services.impl;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.manabi.entities.User;
import ro.manabi.repositories.UserRepository;
import ro.manabi.security.SecurityConfig;
import ro.manabi.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public User findByUsername(String user) {
		return userRepository.findByUsername(user);
	}

	@Override
	public User createUser(String user, String password, String name,  int role) throws Exception {
		User localUser = userRepository.findByUsername(user);
		
		if(localUser == null) {
			localUser = new User(user, SecurityConfig.bCryptPasswordEncoder().encode(password), name, role);
			userRepository.save(localUser);
		}
		
		return localUser;
	}

	@Override
	public boolean changeUserPassword(Principal principal, String newPassword, String currentPassword) {
		User localUser = userRepository.findByUsername(principal.getName());
		
		if(SecurityConfig.bCryptPasswordEncoder().matches(currentPassword, localUser.getPassword())){
			localUser.setPassword(SecurityConfig.bCryptPasswordEncoder().encode(newPassword));			
			userRepository.save(localUser);
			return true;
		}		
		return false;
	}


}
