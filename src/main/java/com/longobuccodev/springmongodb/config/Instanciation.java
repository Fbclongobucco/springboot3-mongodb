package com.longobuccodev.springmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.longobuccodev.springmongodb.domain.Post;
import com.longobuccodev.springmongodb.domain.User;
import com.longobuccodev.springmongodb.repository.PostRepository;
import com.longobuccodev.springmongodb.repository.UserRepository;

@Configuration
public class Instanciation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2022"),"partiu viagem!","vou viajar par São Paulo",maria);
		Post post2 = new Post(null, sdf.parse("21/03/2022"),"bom dia!","Acordei feliz hj!",maria);
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));

		postRepository.saveAll(Arrays.asList(post1,post2));
	}

}
