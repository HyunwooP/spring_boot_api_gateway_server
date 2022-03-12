package proj.gateway.apigateway.common.error;

public class NotCertificateException extends RuntimeException {

  public NotCertificateException() {
    super();
  }

  public NotCertificateException(String message) {
    super(message);
  }

  public NotCertificateException(Throwable throwable) {
    super(throwable);
  }

  public NotCertificateException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
