package proj.gateway.apigateway.common.error;

public class FallbackException extends RuntimeException {

  public FallbackException(String message) {
    super(message);
  }

  public FallbackException(Throwable throwable) {
    super(throwable);
  }

  public FallbackException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
