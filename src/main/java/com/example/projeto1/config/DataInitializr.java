package com.example.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.projeto1.entity.User;
import com.example.projeto1.repository.userRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	userRepository userRep;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<User> users = userRep.findAll();

		if (users.isEmpty()) {

			createUser("Rafael", "rafaels.almeida2@gmail.com");
			createUser("Teste", "teste.testando@gmail.com");
			createUser("HUEHUEH", "huehehuehue@gmail.com");
		}
		
		User user = userRep.findByEmailQualquerCoisa("rafaels.almeida2@gmail.com");
		System.out.println(user.getName());
	}
	
	public void createUser(String name, String email) {
		
		User user = new User(name, email);
		
		userRep.save(user);
		
	}
}
