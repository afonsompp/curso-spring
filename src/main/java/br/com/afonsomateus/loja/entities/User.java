package br.com.afonsomateus.loja.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable{

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(notes = "Identificador do usuário", example = "1", position = 0)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank()
  @Size(min = 3)
  private String name;

  @ApiModelProperty(notes = "Email do usuário", required = true, example = "afonsoprad10@gmail.com", position = 2)
  @NotBlank
  @Email
  private String email;

  @ApiModelProperty(notes = "Número de telefone do usuário.", required = true, example = "(69) 99355-1645", position = 3)
  @NotBlank
  @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})")
  private String phone;

  @OneToMany(mappedBy = "user")
  @JsonIgnore
	private List<Order> orders = new ArrayList<>();

  public User(Long id, String name, String email, String phone) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, phone);
  }
}
