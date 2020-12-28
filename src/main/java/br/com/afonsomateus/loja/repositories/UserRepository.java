package br.com.afonsomateus.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.afonsomateus.loja.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
