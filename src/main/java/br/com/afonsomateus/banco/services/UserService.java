package br.com.afonsomateus.banco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.afonsomateus.banco.entities.User;
import br.com.afonsomateus.banco.repositories.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }
}
