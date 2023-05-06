package com.laopao.blog;

import com.laopao.blog.Repository.PostRepository;
import com.laopao.blog.model.Post;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}



	@Bean
	CommandLineRunner commandLineRunner(PostRepository postRepository) {
		return args -> {
			Post post = new Post();
			post.setTitle("My first post001");
			post.setContent("Hello world001!");
			post.setSlug("my-first-post001");
			post.setDateCreated(LocalDateTime.now());
			//post.setDateUpdated(LocalDateTime.now());
			postRepository.save(post);

			System.out.println("Inserted a post: " + post);
		};
	}

}
