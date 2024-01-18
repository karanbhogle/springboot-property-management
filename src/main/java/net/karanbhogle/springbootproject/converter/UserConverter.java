package net.karanbhogle.springbootproject.converter;

import org.springframework.stereotype.Component;

import net.karanbhogle.springbootproject.dto.UserDTO;
import net.karanbhogle.springbootproject.entity.UserEntity;

@Component
public class UserConverter {
	public UserEntity convertDTOToEntity(UserDTO dto) {
		UserEntity pe = new UserEntity();
		pe.setId(dto.getId());
		pe.setName(dto.getName());
		pe.setEmail(dto.getEmail());
		pe.setPassword(dto.getPassword());
		pe.setPhone(dto.getPhone());
		return pe;
	}

	public UserDTO convertEntityToDTO(UserEntity userEntity) {
		UserDTO pd = new UserDTO();
		pd.setId(userEntity.getId());
		pd.setName(userEntity.getName());
		pd.setEmail(userEntity.getEmail());
		pd.setPhone(userEntity.getPhone());
		return pd;
	}
}
