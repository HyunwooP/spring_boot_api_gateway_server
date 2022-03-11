package proj.gateway.apigateway.common.error;

import java.io.IOException;

public class APIResponseException extends IOException {

  public APIResponseException() {
    super("500");
  }

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
