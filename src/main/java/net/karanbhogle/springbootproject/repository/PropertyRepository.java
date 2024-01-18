package net.karanbhogle.springbootproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.karanbhogle.springbootproject.entity.PropertyEntity;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

	//@Query("SELECT p from PropertyEntity p WHERE p.userEntity.id = :userId")
	//below method name is equivalent of using @Query annotation like above
	List<PropertyEntity> findAllByUserEntityId(@Param("userId") Long id);
	
}
