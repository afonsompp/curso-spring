package br.com.afonsomateus.banco.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.afonsomateus.banco.entities.User;
import br.com.afonsomateus.banco.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "(69) 99355-1645");
    User u2 = new User(null, "Alex Green", "alex@gmail.com", "(69) 9345-1685");
    userRepository.saveAll(Arrays.asList(u1, u2));
  }
}
