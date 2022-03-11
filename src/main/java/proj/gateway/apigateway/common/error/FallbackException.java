package proj.gateway.apigateway.common.error;

public class FallBackException extends RuntimeException {

  public FallBackException(String message) {
    super(message);
  }

  public FallBackException(Throwable throwable) {
    super(throwable);
  }

  public FallBackException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
