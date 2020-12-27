package br.com.afonsomateus.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.afonsomateus.banco.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
