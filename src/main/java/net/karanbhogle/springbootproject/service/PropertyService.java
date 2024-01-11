package net.karanbhogle.springbootproject.service;

import java.util.List;

import org.springframework.stereotype.Component;

import net.karanbhogle.springbootproject.dto.PropertyDTO;

@Component
public interface PropertyService {
	public PropertyDTO saveProperty(PropertyDTO propertyDTO);

	public List<PropertyDTO> getAllProperties();

	public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long id);

	public PropertyDTO updatePropertyTitle(PropertyDTO propertyDTO, Long id);

	public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long id);

	public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long id);

	public boolean deleteProperty(Long id);
}
