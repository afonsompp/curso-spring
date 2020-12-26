package br.com.afonsomateus.banco.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.afonsomateus.banco.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @GetMapping
  public ResponseEntity<User> findAllUsers() {
    User u = new User(1L, "Afonso", "afonso@gmail.com", "(69) 9 9355-1645");
    return ResponseEntity.ok().body(u);
  }
}
