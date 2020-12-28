package br.com.afonsomateus.banco.resources;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.afonsomateus.loja.entities.User;
import br.com.afonsomateus.loja.errors.genericExceptions.exceptions.DatabaseException;
import br.com.afonsomateus.loja.errors.genericExceptions.exceptions.ResourceNotFoundException;
import br.com.afonsomateus.loja.resources.UserResource;
import br.com.afonsomateus.loja.services.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
  UserResource.class
})
@AutoConfigureMockMvc
public class UserResourseTests {

  private final String BASE_URL = "/users";

  private ObjectMapper objectMapper;
  @Autowired
  private UserResource userResource;
  @MockBean
  private UserService userService;

  private MockMvc mockMvc;

  @Before
  public void setUp() {
    objectMapper = new ObjectMapper();
    mockMvc = MockMvcBuilders
      .standaloneSetup(userResource)
      .build();
  }

  @Test
  public void findById_200() throws Exception{
    User user = new User(
      1L,
      "Afonso",
      "afonso@gmai.com",
      "(69) 99355-1645"
    );

    when(userService.findById(1L)).thenReturn(user);

    mockMvc.perform(get(BASE_URL + "/1"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.id", is(user.getId().intValue())))
    .andExpect(jsonPath("$.name", is(user.getName())))
    .andExpect(jsonPath("$.email", is(user.getEmail())))
    .andExpect(jsonPath("$.phone", is(user.getPhone())));

  }

  @Test
  public void findById_404() throws Exception{
    when(userService.findById(2L)).thenThrow(new ResourceNotFoundException(2L));
  }

  @Test
  public void insert_201() throws Exception{
    User user = new User(
      null,
      "Afonso",
      "afonso@gmai.com",
      "(69) 99355-1645"
    );

    when(userService.insert(any(User.class))).thenReturn(user);

    mockMvc.perform(post(BASE_URL)
      .content(objectMapper.writeValueAsString(user))
      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
      .andExpect(status().isCreated())
      .andExpect(jsonPath("$.id", is(user.getId())))
      .andExpect(jsonPath("$.name", is(user.getName())))
      .andExpect(jsonPath("$.email", is(user.getEmail())))
      .andExpect(jsonPath("$.phone", is(user.getPhone())));

    verify(userService, times(1)).insert(any(User.class));
  }

  @Test
  public void insert_400() throws Exception{
    User user = new User(
      null,
      "Afonso",
      "afonso@gmai.com",
      "(69) 993551645"
    );

    mockMvc.perform(post(BASE_URL)
      .content(objectMapper.writeValueAsString(user))
      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
      .andExpect(status().isBadRequest());
  }

  @Test
  public void updateById_200() throws Exception{

    User user = new User(
      null,
      "Afonso carlos",
      "afonso@gmai.com",
      "(69) 99355-1645"
    );

    when(userService.update(eq(1L), any(User.class))).thenReturn(user);

    mockMvc.perform(put(BASE_URL + "/1")
      .content(objectMapper.writeValueAsString(user))
      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.name", is(user.getName())))
      .andExpect(jsonPath("$.email", is(user.getEmail())))
      .andExpect(jsonPath("$.phone", is(user.getPhone())));
  }
  @Test
  public void updateById_404() throws Exception{
    mockMvc.perform(get(BASE_URL + "/10")).andExpect(status().isNotFound());
  }

  @Test
  public void updateById_400() throws Exception{
    User user = new User(
      null,
      "Af",
      "afonso@gmai.com",
      "(69) 99355-1645"
    );

    mockMvc.perform(put(BASE_URL + "/1")
      .content(objectMapper.writeValueAsString(user))
      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
      .andExpect(status().isBadRequest());
  }

  @Test
  public void delete_200() throws Exception{
    when(userService.deleteById(eq(1L))).thenReturn(true);
  }

  @Test
  public void delete_404() throws Exception{
    when(userService.deleteById(eq(2L))).thenThrow(new ResourceNotFoundException(1L));
  }

  @Test
  public void delete_400() throws Exception{
    when(userService.deleteById(eq(3L))).thenThrow(new DatabaseException(""));
  }


}
