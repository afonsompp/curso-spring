package br.com.afonsomateus.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.afonsomateus.banco.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
