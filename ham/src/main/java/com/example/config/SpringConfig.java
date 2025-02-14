package com.example.config;

import com.example.repository.JdbcTemplateMemberRepository;
import com.example.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Bean
    MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
