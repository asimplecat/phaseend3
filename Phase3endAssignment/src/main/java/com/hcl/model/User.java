package com.hcl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id @GeneratedValue
	private Long id;
	private String uname;
	private String password;
	private String email;
}
