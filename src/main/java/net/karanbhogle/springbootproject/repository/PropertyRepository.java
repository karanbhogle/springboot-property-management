package net.karanbhogle.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.karanbhogle.springbootproject.entity.PropertyEntity;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
	
}
