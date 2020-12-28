package br.com.afonsomateus.loja.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.afonsomateus.loja.entities.pk.OrderItemPK;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private OrderItemPK id = new OrderItemPK();

  @NotNull
  private Integer quantity;

  @NotNull
  private Double price;


  public OrderItem() {
  }

  public OrderItem(Order order, Product product, Integer quantity, Double price) {
    this.id.setOrder(order);
    this.id.setProduct(product);
    this.quantity = quantity;
    this.price = price;
  }
  @JsonIgnore
  public Order getOrder() {
    return this.id.getOrder();
  }

  public void setOrder(Order order) {
    this.id.setOrder(order);
  }

  public Product getProduct() {
    return this.id.getProduct();
  }

  public void setProduct(Product product) {
    this.id.setProduct(product);
  }

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getSubTotal() {
    return this.price * this.quantity;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderItem)) {
            return false;
        }
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

}
