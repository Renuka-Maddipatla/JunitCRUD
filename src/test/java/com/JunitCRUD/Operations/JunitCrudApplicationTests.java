package com.JunitCRUD.Operations;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.JunitCRUD.Operations.Entity.Student;
import com.JunitCRUD.Operations.Repository.StudentRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class JunitCrudApplicationTests {
@Autowired
private StudentRepository studentrepository;


@Test
@Order(1)
@Rollback(value = false)
	
	public void saveStudent() {
		Student student = Student.builder()
				.name("madhu")
				.location("Hyderabad")
				.subject("java")
				.build();
		studentrepository.save(student);
		Assertions.assertThat(student.getId()).isGreaterThan(0);
	}

@Test
@Order(2)
public void getListEmployees() {
	List<Student> student =studentrepository.findAll();
	Assertions.assertThat(student.size()).isGreaterThan(7);
}
@Test
@Order(3)
@Rollback(value = false)
public void updateStudent() {
	Student student = studentrepository.findById(7).get();
	  student.setSubject("java");
	Student studentupdated = studentrepository.save(student);
	Assertions.assertThat(studentupdated.getSubject()).isEqualTo("java");
}

@Test
@Order(4)
@Rollback(value = false)
public void DeleteStudent() {
	Student student = studentrepository.findById(9).get();
	studentrepository.delete(student);
	  Student students =null;
//	Optional <Student> optional = studentrepository.findBySubject("Java");
//if (optional .isPresent()){
//		students = optional.get();
//	}

	Assertions.assertThat(students).isNull();
	
}

	}


