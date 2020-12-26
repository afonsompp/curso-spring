package br.com.afonsomateus.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.afonsomateus.banco.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
