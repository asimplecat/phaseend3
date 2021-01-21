package com.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.TaskRepository;
import com.hcl.dao.UserRepository;
import com.hcl.model.Task;
import com.hcl.model.User;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired 
    TaskRepository repo;
    
    public void save(Task user) {
        repo.save(user);
    }
    
    public List<Task> listAll() {
        return (List<Task>) repo.findAll();
    }
    
    public Task get(Long id) {
        return repo.findById(id).get();
    }
    
    public void delete(Long id) {
        repo.deleteById(id);
    }

	public List<Task> filterByEmail(String email) {
		List<Task> t = listAll();
		List<Task> onlyMatchingEmail = new ArrayList<Task>();
		for (Task x : t)
		{
			if (x.getEmail().equals(email))
			{
				onlyMatchingEmail.add(x);
			}
		}
		return onlyMatchingEmail;
		
	}


}