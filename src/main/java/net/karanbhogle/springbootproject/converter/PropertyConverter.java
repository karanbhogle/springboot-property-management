package net.karanbhogle.springbootproject.converter;

import org.springframework.stereotype.Component;

import net.karanbhogle.springbootproject.dto.PropertyDTO;
import net.karanbhogle.springbootproject.entity.PropertyEntity;

@Component
public class PropertyConverter {
	public PropertyEntity convertDTOToEntity(PropertyDTO propertyDTO) {
		PropertyEntity pe = new PropertyEntity();
		pe.setId(propertyDTO.getId());
		pe.setTitle(propertyDTO.getTitle());
		pe.setDescription(propertyDTO.getDescription());
		pe.setPrice(propertyDTO.getPrice());
		return pe;
	}

	public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity) {
		PropertyDTO pd = new PropertyDTO();
		pd.setId(propertyEntity.getId());
		pd.setTitle(propertyEntity.getTitle());
		pd.setDescription(propertyEntity.getDescription());
		pd.setPrice(propertyEntity.getPrice());
		return pd;
	}
}
