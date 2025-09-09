package com.mihayvictor.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mihayvictor.workshopmongo.domain.User;
import com.mihayvictor.workshopmongo.dto.UserDTO;
import com.mihayvictor.workshopmongo.repository.UserRepository;
import com.mihayvictor.workshopmongo.services.exception.ObjectNotFondException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFondException("Objeto Não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	public void delete(String id) {
		User user = repo.findById(id).orElseThrow(()-> new ObjectNotFondException("Objeto Não encontrado" + id));
		repo.deleteById(user.getId());
	}
}
