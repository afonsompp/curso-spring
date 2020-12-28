package br.com.afonsomateus.loja.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.afonsomateus.loja.entities.Order;
import br.com.afonsomateus.loja.entities.Product;

@Embeddable
public class OrderItemPK implements Serializable{

  private static final long serialVersionUID = 1L;

  @NotNull(message = "Order cannot be null")
  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;
  @NotNull(message = "Product cannot be null")
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  public OrderItemPK() {
  }

  public OrderItemPK(Order order, Product product) {
    this.order = order;
    this.product = product;
  }

  public Order getOrder() {
    return this.order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Product getProduct() {
    return this.product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof OrderItemPK)) {
      return false;
    }
    OrderItemPK orderItemPK = (OrderItemPK) o;
    return Objects.equals(order, orderItemPK.order) && Objects.equals(product, orderItemPK.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(order, product);
  }


}
