package net.karanbhogle.springbootproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.karanbhogle.springbootproject.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	Optional<UserEntity> findByEmailAndPassword(String email, String password);
	Optional<UserEntity> findByEmail(String email);
}
