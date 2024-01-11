package net.karanbhogle.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.karanbhogle.springbootproject.dto.PropertyDTO;
import net.karanbhogle.springbootproject.service.PropertyService;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {
	
	@Autowired
	PropertyService propertyService;
	

	@Value("${spring.profiles.active}")
	String currentActiveProfile;
	
	@GetMapping("/hello")
	public String hello() {
		System.out.println("Current Active Profile: " + currentActiveProfile);
		return "Hello World";
	}
	
	@PostMapping("/properties")
	public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
		PropertyDTO responseDTO = propertyService.saveProperty(propertyDTO);
		return new ResponseEntity<PropertyDTO>(responseDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/properties")
	public ResponseEntity<List<PropertyDTO>> getAllProperties() {
		List<PropertyDTO> responseDTOs = propertyService.getAllProperties();
		return new ResponseEntity<List<PropertyDTO>>(responseDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/properties/{id}")
	public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id) {
		PropertyDTO responseDTO = propertyService.updateProperty(propertyDTO, id);
		return new ResponseEntity<PropertyDTO>(responseDTO, HttpStatus.OK);
	}
	
	@PatchMapping("/properties/updateTitle/{id}")
	public ResponseEntity<PropertyDTO> updatePropertyTitle(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id) {
		PropertyDTO responseDTO = propertyService.updatePropertyTitle(propertyDTO, id);
		return new ResponseEntity<PropertyDTO>(responseDTO, HttpStatus.OK);
	}
	
	@PatchMapping("/properties/updateDescription/{id}")
	public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id) {
		PropertyDTO responseDTO = propertyService.updatePropertyDescription(propertyDTO, id);
		return new ResponseEntity<PropertyDTO>(responseDTO, HttpStatus.OK);
	}
	
	@PatchMapping("/properties/updatePrice/{id}")
	public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id) {
		PropertyDTO responseDTO = propertyService.updatePropertyPrice(propertyDTO, id);
		return new ResponseEntity<PropertyDTO>(responseDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/properties/deleteProperty/{id}")
	public ResponseEntity<String> deleteProperty(@PathVariable Long id) {
		boolean isDeleted = propertyService.deleteProperty(id);
		String message = "";
		if(isDeleted) {
			message = "Deleted Successfully";
		} else {
			message = "No such property";
		}
		return new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
	}
}
