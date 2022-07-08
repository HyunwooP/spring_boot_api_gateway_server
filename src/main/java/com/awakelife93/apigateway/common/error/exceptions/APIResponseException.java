package com.awakelife93.apigateway.common.error.exceptions;

import java.io.IOException;

public class APIResponseException extends IOException {

  public APIResponseException(String message) {
    super(message);
  }

  public APIResponseException(Throwable throwable) {
    super(throwable);
  }

  public APIResponseException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
