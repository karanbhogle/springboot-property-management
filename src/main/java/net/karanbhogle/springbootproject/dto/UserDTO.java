package net.karanbhogle.springbootproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
	private Long id;
	private String name;
	
	@NotNull(message = "Email is mandatory")
	@NotEmpty(message = "Email cannot be empty")
	@Size(min = 1, max = 50, message = "Email should be between 1 to 50 characters")
	private String email;

	@NotNull
	@NotEmpty(message = "Password cannot be empty")
	private String password;
	
	@NotNull
	@NotEmpty(message = "Phone cannot be empty")
	private String phone;
}
