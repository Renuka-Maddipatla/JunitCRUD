package com.JunitCRUD.Operations.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table (name = "Student")
public class Student {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
 private int id;
	@Column (name ="name")
	private String name;
	@Column (name = "location")
	private String location;
	@Column (name = "subject")
	private String subject;
}
