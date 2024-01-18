package net.karanbhogle.springbootproject.service;

import org.springframework.stereotype.Component;
import net.karanbhogle.springbootproject.dto.UserDTO;

@Component
public interface UserService {
	public UserDTO register(UserDTO userDTO);

	public UserDTO login(UserDTO userDTO);

	public boolean deleteUser(Long id);
}
