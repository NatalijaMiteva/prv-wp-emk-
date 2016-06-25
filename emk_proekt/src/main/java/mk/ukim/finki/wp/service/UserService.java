package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.User;

public interface UserService extends BaseEntityCrudService<User>{

	public User findByUsername(String username);


    
}
