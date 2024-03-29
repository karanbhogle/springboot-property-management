package net.karanbhogle.springbootproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "property_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	private String description;
	
	@Column(nullable = false)
	private Double price;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	// it will not fetch user data while fetching the property. By default, it's EAGER.
	@JoinColumn(name = "USER_ID", nullable = false)
	private UserEntity userEntity;
}
