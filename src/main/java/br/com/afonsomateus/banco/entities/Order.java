package br.com.afonsomateus.banco.entities;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.afonsomateus.banco.entities.enums.OrderStatus;

@Entity
@Table(name = "tb_order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Date cannot be null")
  @PastOrPresent(message = "Date must be past or present")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "GMT")
  private Instant moment;

  @NotNull(message = "OrderStatus cannot be null")
  @Max(value = 5, message = "value out range, valid values between 1 and 5")
  @Min(value = 1, message = "value out range, valid values between 1 and 5")
  private Integer orderStatus;

  @ManyToOne()
  @JoinColumn(name = "user_id")
  @NotNull(message = "User cannot be null")
  private User user;

  public Order() {
  }

  public Order(Long id, Instant moment, OrderStatus orderStatus, User user) {
    this.id = id;
    this.moment = moment;
    this.orderStatus = orderStatus.getCode();
    this.user = user;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Instant getMoment() {
    return this.moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Order)) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(id, order.id) ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, moment, user);
  }
}
