package br.com.afonsomateus.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.afonsomateus.loja.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
