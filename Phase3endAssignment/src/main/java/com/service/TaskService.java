package com.service;
import java.util.List;

import com.hcl.model.Task;
import com.hcl.model.User;

public interface TaskService {

	public void save(Task task);

	public List<Task> listAll();
	
	public void delete(Long id);

	public Task get(Long id );

}