package br.com.afonsomateus.loja.errors.validationException;

import java.util.List;

public class ErrorResponse {

  private final String message;
  private final int code;
  private final String status;
  private final String objectName;
  private final List<ErrorObject> errors;

  public ErrorResponse(String message, int code, String status, String objectName, List<ErrorObject> errors) {
    this.message = message;
    this.code = code;
    this.status = status;
    this.objectName = objectName;
    this.errors = errors;
  }

  public String getMessage() {
    return this.message;
  }

  public int getCode() {
    return this.code;
  }

  public String getStatus() {
    return this.status;
  }

  public String getObjectName() {
    return this.objectName;
  }

  public List<ErrorObject> getErrors() {
    return this.errors;
  }

}
