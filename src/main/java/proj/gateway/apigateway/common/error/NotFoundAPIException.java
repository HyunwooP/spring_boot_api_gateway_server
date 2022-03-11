package proj.gateway.apigateway.common.error;

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
