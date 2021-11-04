package tn.esprit.spring.services;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			l.info("In method retrieveAllUsers :"); 
			users = (List<User>) userRepository.findAll();  
			l.debug("connexion à la DB Ok:");
			
			for (User user : users) {
				l.debug("user :" + user.getLastName());
			} 
			l.info("Out of method retrieveAllUsers with success");
		}catch (Exception e) {
			l.error("Out of method retrieveAllUsers with Error :"+ e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		l.info("In of Methode adduser:");
		User u_saved = userRepository.save(u); 
		l.info("Out of Methode adduser:");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		l.info("In of Methode updateUser:"); 
		User u_saved = userRepository.save(u); 
		l.info("Out of Methode updateUser:");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		l.info("In of Methode deleteUser:");
		userRepository.deleteById(Long.parseLong(id)); 
		l.info("Out of Methode deleteUser:");
	}

	@Override
	public User retrieveUser(String id) {
		l.info("In of Methode retrieveUser:");
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		l.info("Out of Methode retrieveUser:");
		return u; 
	}

}
