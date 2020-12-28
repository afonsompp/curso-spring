package br.com.afonsomateus.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.afonsomateus.loja.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
