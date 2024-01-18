package net.karanbhogle.springbootproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.karanbhogle.springbootproject.converter.UserConverter;
import net.karanbhogle.springbootproject.dto.UserDTO;
import net.karanbhogle.springbootproject.entity.UserEntity;
import net.karanbhogle.springbootproject.exception.BusinessException;
import net.karanbhogle.springbootproject.exception.ErrorModel;
import net.karanbhogle.springbootproject.repository.UserRepository;
import net.karanbhogle.springbootproject.service.UserService;
import net.karanbhogle.springbootproject.utils.MessageHelper;
import net.karanbhogle.springbootproject.utils.UserSecurityHelper;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserConverter converter;
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDTO register(UserDTO userDTO) {
		UserEntity ue = null;
		Optional<UserEntity> optionalUE = repository.findByEmail(userDTO.getEmail());
		if(optionalUE.isPresent()) {
			List<ErrorModel> errorModel = MessageHelper.getErrorMessageList("USER_ALREADY_EXISTS", "User with this mail already exists");
			throw new BusinessException(errorModel);
		}
		ue = converter.convertDTOToEntity(userDTO);
		ue.setPassword(UserSecurityHelper.hashString(ue.getPassword()));
		UserEntity savedUE = repository.save(ue);
		
		//savedenttiy to be converted to DTO and return it
		return converter.convertEntityToDTO(savedUE);
	}

	@Override
	public UserDTO login(UserDTO userDTO) {
		UserDTO responseDTO = null;
		userDTO.setPassword(UserSecurityHelper.hashString(userDTO.getPassword()));
		Optional<UserEntity> optionalUE = repository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
		if(optionalUE.isPresent()) {
			responseDTO = converter.convertEntityToDTO(optionalUE.get());
		} else {
			List<ErrorModel> errorModel = MessageHelper.getErrorMessageList("INVALID_LOGIN", "Incorrect Email or Password");
			throw new BusinessException(errorModel);
		}
		
		return responseDTO;
	}

	@Override
	public boolean deleteUser(Long id) {
		Optional<UserEntity> optUE = repository.findById(id);
		if(optUE.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		
		return false;
	}

	

}
