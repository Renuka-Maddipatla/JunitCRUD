package com.JunitCRUD.Operations.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JunitCRUD.Operations.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	Optional<Student> findBySubject(String Subject);

	
	
}
