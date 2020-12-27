package br.com.afonsomateus.banco.errors.validationException;

import java.io.Serializable;

public class ErrorObject implements Serializable{

  private static final long serialVersionUID = 1L;
  private final String message;
  private final String field;
  private final Object parameter;

  public ErrorObject(String message, String field, Object parameter) {
    this.message = message;
    this.field = field;
    this.parameter = parameter;
  }

  public String getMessage() {
    return this.message;
  }

  public String getField() {
    return this.field;
  }

  public Object getParameter() {
    return this.parameter;
  }
}
