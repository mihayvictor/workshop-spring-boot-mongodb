package com.mihayvictor.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mihayvictor.workshopmongo.domain.Post;
import com.mihayvictor.workshopmongo.domain.User;
import com.mihayvictor.workshopmongo.repository.PostRepository;
import com.mihayvictor.workshopmongo.services.exception.ObjectNotFondException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFondException("Objeto Não encontrado"));
	}
	
}
