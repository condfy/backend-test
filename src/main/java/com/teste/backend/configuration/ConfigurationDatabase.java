package com.teste.backend.configuration;

import com.teste.backend.entity.User;
import com.teste.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationDatabase {

    @Autowired private UserRepository userRepository;

    @Bean
    public String fillDatabase() {
        userRepository.save(new User("Lucas", "lucasl@mail.com", 30));
        userRepository.save(new User("Alice", "alice@mail.com", 35));
        userRepository.save(new User("Daniel", "danielr@mail.com", 30));
        userRepository.save(new User("Amanda", "amanda@mail.com", 55));
        userRepository.save(new User("Sara", "sara@mail.com", 24));
        userRepository.save(new User("Lucas", "lucas@mail.com", 10));
        userRepository.save(new User("Daniel", "daniel@mail.com", 60));
        userRepository.save(new User("Lara", "lara@mail.com", 19));
        userRepository.save(new User("Lucas", "lucasw@mail.com", 18));

        return null;
    }

}
