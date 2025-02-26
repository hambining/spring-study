package com.example.ham;

import com.example.config.SpringConfig;
import com.example.domain.Member;
import com.example.repository.MemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class HamApplication {

	public static void main(String[] args) {
		SpringApplication.run(HamApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		MemberRepository repository = context.getBean(MemberRepository.class);

		Member member = new Member(1L, "Ham");
		Member member1 = new Member();
		member1.setName("Ham2");
		member1.setId(2L);
		repository.save(member);
		repository.save(member1);

		repository.findAll().forEach(System.out::println);
		repository.findById(1L).stream().forEach(System.out::println);
		repository.findByName("Ham").stream().forEach(System.out::println);
	}

}
