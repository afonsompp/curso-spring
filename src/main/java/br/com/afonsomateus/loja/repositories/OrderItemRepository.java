package br.com.afonsomateus.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.afonsomateus.loja.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
