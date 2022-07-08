package com.awakelife93.apigateway.common.error.exceptions;

public class NotFoundAPIException extends RuntimeException {

  public NotFoundAPIException() {
    super();
  }

  public NotFoundAPIException(String message) {
    super(message);
  }

  public NotFoundAPIException(Throwable throwable) {
    super(throwable);
  }

  public NotFoundAPIException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
