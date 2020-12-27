package br.com.afonsomateus.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.afonsomateus.banco.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
