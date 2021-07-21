package ro.manabi.services;

import java.security.Principal;

import ro.manabi.entities.User;

public interface UserService {

	User findByUsername(String user);
	User createUser(String name, String user, String password, int role) throws Exception;
	boolean changeUserPassword(Principal principal, String newPassword, String currentPassword);
}
