package com.hcl.dao;

import org.springframework.data.repository.CrudRepository;

import com.hcl.model.Task;


public interface TaskRepository extends CrudRepository<Task, Long> {

	
}
