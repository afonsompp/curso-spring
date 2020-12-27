package br.com.afonsomateus.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.afonsomateus.banco.entities.User;
import br.com.afonsomateus.banco.errors.genericExceptions.exceptions.ResourceNotFoundException;
import br.com.afonsomateus.banco.repositories.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(Long id) {
    Optional<User> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public User insert(User user) {
    return repository.save(user);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  public User update(Long id, User user) {
    User entity = repository.getOne(id);
    updateData(user, entity);
    return repository.save(entity);
  }

  private void updateData(User user, User entity) {
    entity.setName(user.getName());
    entity.setEmail(user.getEmail());
    entity.setPhone(user.getPhone());
  }
}
