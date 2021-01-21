package com.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.UserRepository;
import com.hcl.model.Task;
import com.hcl.model.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired 
    UserRepository repo;
    
    private User currentSessionUser = null;
    
    public void save(User user) {
        repo.save(user);
    }
    
    public List<User> listAll() {
    	
        return (List<User>) repo.findAll();
    }
    
    public User get(Long id) {
        return repo.findById(id).get();
    }
    
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public User login(String uname, String pass) {
    	
    	for (User x : listAll() )
    	{
    		if (x.getUname().equals(uname) && x.getPassword().equals(pass)) {
    			currentSessionUser = x;
    			return x;
    		}
    	}	
		return null;
	}


	public void logout() {
		currentSessionUser = null;
	}
	
	public Long getId() {
		if (currentSessionUser == null) {
			return null;
		}
		return currentSessionUser.getId();
	}
	
	public User getCurrentSessionUser() {
		return currentSessionUser;
	}

	
    
}