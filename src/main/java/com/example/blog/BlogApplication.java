package com.example.blog;

import com.example.blog.models.Account;
import com.example.blog.models.Post;
import com.example.blog.repositories.AccountRepository;
import com.example.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void run(String... args) throws Exception {

		if (postRepository.count() == 0) {

			Account account1 = new Account("oly@domail.com", "1234", "Oly", "Stephen");
			Account account2 = new Account("prof@gmail.com", "5678", "Prof", "Micheal");

			accountRepository.save(account1);
			accountRepository.save(account2);

			Post post1 = new Post("What is CS", "CS stands for Computer Science. It is a field of study" +
					" which deals with the theoretical foundations of information and" +
					" computation, and with practical techniques for their implementation" +
					" and application in computer systems.", LocalDateTime.now());
			post1.setAccount(account1);
			postRepository.save(post1);

			Post post2 = new Post("What is Technology", "Technology is the application of scientific " +
					"knowledge for practical purposes, especially in industry. It involves the use of machines," +
					" tools, systems, and processes to solve problems and improve efficiency.",
					LocalDateTime.now());
			post2.setAccount(account2);
			postRepository.save(post2);
		}
	}
}