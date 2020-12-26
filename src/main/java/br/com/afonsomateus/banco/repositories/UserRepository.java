package br.com.afonsomateus.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.afonsomateus.banco.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
