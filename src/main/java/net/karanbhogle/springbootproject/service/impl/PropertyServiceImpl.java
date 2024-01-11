package net.karanbhogle.springbootproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import net.karanbhogle.springbootproject.converter.PropertyConverter;
import net.karanbhogle.springbootproject.dto.PropertyDTO;
import net.karanbhogle.springbootproject.entity.PropertyEntity;
import net.karanbhogle.springbootproject.repository.PropertyRepository;
import net.karanbhogle.springbootproject.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService{

	@Autowired
	PropertyConverter converter;
	
	@Autowired
	PropertyRepository repository;
	
	@Override
	public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
		//convert DTO to Entity
		PropertyEntity pe = converter.convertDTOToEntity(propertyDTO);
		
		//save that entity object to DB
		//db will return saved entity
		PropertyEntity savedPE = repository.save(pe);
		
		//savedenttiy to be converted to DTO and return it
		PropertyDTO responseDTO = converter.convertEntityToDTO(savedPE);
		return responseDTO;
	}

	@Override
	public List<PropertyDTO> getAllProperties() {
		List<PropertyEntity> foundPEList = repository.findAll();
		List<PropertyDTO> responseList = new ArrayList<>();
		for(PropertyEntity pe: foundPEList) {
			PropertyDTO pd = converter.convertEntityToDTO(pe);
			responseList.add(pd);
		}
		return responseList;
	}

	@Override
	public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long id) {
		//find if such property exists or not
		Optional<PropertyEntity> optionalPE = repository.findById(id);
		
		// if exists then update and return
		if(optionalPE.isPresent()) {
			PropertyEntity pe = optionalPE.get();
			pe.setId(propertyDTO.getId());
			pe.setTitle(propertyDTO.getTitle());
			pe.setDescription(propertyDTO.getDescription());
			pe.setPrice(propertyDTO.getPrice());
			
			pe = repository.save(pe);
			
			return converter.convertEntityToDTO(pe);
		}
		
		//else return null
		return null;
	}

	@Override
	public PropertyDTO updatePropertyTitle(PropertyDTO propertyDTO, Long id) {
		Optional<PropertyEntity> optionalPE = repository.findById(id);
		
		if(optionalPE.isPresent()) {
			PropertyEntity pe = optionalPE.get();
			pe.setTitle(propertyDTO.getTitle());
					
			pe = repository.save(pe);
					
			return converter.convertEntityToDTO(pe);
		}
				
		return null;
	}

	@Override
	public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long id) {
		Optional<PropertyEntity> optionalPE = repository.findById(id);
		
		if(optionalPE.isPresent()) {
			PropertyEntity pe = optionalPE.get();
			pe.setDescription(propertyDTO.getDescription());
			
			pe = repository.save(pe);
			
			return converter.convertEntityToDTO(pe);
		}
		
		return null;
	}

	@Override
	public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long id) {
		Optional<PropertyEntity> optionalPE = repository.findById(id);
		
		if(optionalPE.isPresent()) {
			PropertyEntity pe = optionalPE.get();
			pe.setPrice(propertyDTO.getPrice());
			
			pe = repository.save(pe);
			
			return converter.convertEntityToDTO(pe);
		}
		
		return null;
	}

	@Override
	public boolean deleteProperty(Long id) {
		Optional<PropertyEntity> optionalPE = repository.findById(id);
		
		if(optionalPE.isPresent()) {
			repository.deleteById(id);
			
			return true;
		}
		return false;
	}

}
