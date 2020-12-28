package br.com.afonsomateus.loja.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.afonsomateus.loja.entities.User;
import br.com.afonsomateus.loja.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/users")
@Api(tags = "Users", description = "Rota de usuários")
public class UserResource {

  @Autowired
  private UserService userService;


  @ApiOperation(value = "Lista os usuários")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Usuários retornados com sucesso."),
    @ApiResponse(code = 500, message = "Ocorrência de erro interno no servidor."),
  })
  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> u = userService.findAll();
    return ResponseEntity.ok().body(u);
  }

  @ApiOperation(value = "Busca um usuário pelo Id")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Usuário retornados com sucesso."),
    @ApiResponse(code = 400, message = "Parâmetro passado na URL é inválido."),
    @ApiResponse(code = 404, message = "Sem registros de um usuário com este Id."),
    @ApiResponse(code = 500, message = "Ocorrência de erro interno no servidor."),
  })
  @GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = userService.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @ApiOperation(value = "Cria um usuário")
  @ResponseStatus(code = HttpStatus.CREATED)
  @ApiResponses(value = {
    @ApiResponse(code = 201, message = "Dados retornados com sucesso."),
    @ApiResponse(code = 400, message = "JSON passado cotém valores que não atendem as especificações da entidade."),
    @ApiResponse(code = 500, message = "Ocorrência de erro interno no servidor."),
  })
  @PostMapping
	public ResponseEntity<User> insert(@Valid @RequestBody User user) {
    userService.insert(user);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).body(user);
  }
  @ApiOperation(value = "Deleta um usuário")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  @ApiResponses(value = {
    @ApiResponse(code = 204, message = "Usuário deletado com sucesso."),
    @ApiResponse(code = 400, message = "Parâmetro passado na URL é inválido."+
    "Ou registro está relacionado com outro"),
    @ApiResponse(code = 404, message = "Sem registros de um usuário com este Id."),
    @ApiResponse(code = 500, message = "Ocorrência de erro interno no servidor."),
  })
  @DeleteMapping(value = "/{id}")
	public ResponseEntity<User> deleteById(@PathVariable Long id) {
		userService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @ApiOperation(value = "Atualiza um usuário")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Usuário atualizados com sucesso."),
    @ApiResponse(code = 400, message = "JSON passado cotém valores que não atendem as especificações da entidade."),
    @ApiResponse(code = 404, message = "Não encontrou o usuário a ser atualizado."),
    @ApiResponse(code = 500, message = "Ocorrência de erro interno no servidor."),
  })
  @PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User user) {
    user = userService.update(id, user);
    return ResponseEntity.ok().body(user);
  }
}
