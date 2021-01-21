package com.hcl.model;


import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Table(name = "Tasks")
@AllArgsConstructor
@NoArgsConstructor
public class Task {
	
	@Id @GeneratedValue
	private Long id;
	private String taskName;
	private Date startDate;
	private Date endDate;
	private String Description;
	private String email;
	private String severity;

}
