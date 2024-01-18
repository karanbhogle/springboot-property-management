package net.karanbhogle.springbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import net.karanbhogle.springbootproject.dto.UserDTO;
import net.karanbhogle.springbootproject.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World from User Controller";
	}
	@Operation(summary = "Register a user", description = "This is used to register a user in the database")
	@PostMapping("/register")
	public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO userDTO) {
		UserDTO responseDTO = service.register(userDTO);
		return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/login", consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<UserDTO> login(@Valid @RequestBody UserDTO userDTO) {
		UserDTO responseDTO = service.login(userDTO);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		boolean isDeleted = service.deleteUser(id);
		String response = null;
		
		if(isDeleted) {
			response = "User at id " + id + " deleted successfully";
		} else {
			response = "User at id " + id + " doesn't exists";
		}
		return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
	}
	
}
