package proj.gateway.apigateway.common.error;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.common.error.exceptions.FallBackException;

@EnableWebMvc
@RestControllerAdvice
public class ErrorHandler {
  private static final HashMap<HttpStatus, String> errorMap = new HashMap<HttpStatus, String>() {
    {
      put(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED");
      put(HttpStatus.FORBIDDEN, "FORBIDDEN");
      put(HttpStatus.NOT_FOUND, "NOT_FOUND");
      put(HttpStatus.BAD_REQUEST, "BAD_REQUEST");
      put(HttpStatus.CONFLICT, "CONFLICT");
      put(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");
      put(HttpStatus.TOO_MANY_REQUESTS, "TOO_MANY_REQUESTS");
      put(HttpStatus.BAD_GATEWAY, "BAD_GATEWAY");
    }
  };

  private String getErrorMessage(HttpStatus status) {
    return errorMap.get(status);
  }

  private HashMap<String, Object> getResponseErrorMap(HttpStatus status) {
    HashMap<String, Object> responseErrorMap = new HashMap<String, Object>();

    String message = getErrorMessage(status);

    responseErrorMap.put("status", status.value());
    responseErrorMap.put("message", message);

    return responseErrorMap;
  }

  @ExceptionHandler(Exception.class)
  private ResponseEntity<HashMap<String, Object>> exceptionHandler(Throwable throwable) {
    System.out.println("============= Unknown Error =============" + " : " + new Date().getTime());
    System.out.println(throwable.getMessage());
    System.out.println("=========================================");

    HashMap<String, Object> responseErrorMap = getResponseErrorMap(HttpStatus.INTERNAL_SERVER_ERROR);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseErrorMap);
  }

  @ExceptionHandler(APIResponseException.class)
  private ResponseEntity<HashMap<String, Object>> apiResponseExceptionHandler(Throwable throwable) {
    System.out.println("============= API Error =============" + " : " + new Date().getTime());
    String status = throwable.getMessage();
    HttpStatus apiErrorCode = HttpStatus.valueOf(Integer.parseInt(status));

    HashMap<String, Object> responseErrorMap = getResponseErrorMap(apiErrorCode);
    return ResponseEntity.status(apiErrorCode).body(responseErrorMap);
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  private ResponseEntity<HashMap<String, Object>> notFoundExceptionHandler(Throwable throwable) {
    System.out.println("============= NotFound Error =============" + " : " + new Date().getTime());

    HashMap<String, Object> responseErrorMap = getResponseErrorMap(HttpStatus.NOT_FOUND);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseErrorMap);
  }

  @ExceptionHandler(FallBackException.class)
  private ResponseEntity<HashMap<String, Object>> fallbackExceptionHandler(Throwable throwable) {
    System.out.println("============= FallBack Error =============" + " : " + new Date().getTime());
    String status = throwable.getMessage();
    HttpStatus fallBackErrorCode = status == null ? HttpStatus.TOO_MANY_REQUESTS
        : HttpStatus.valueOf(Integer.parseInt(status));

    HashMap<String, Object> responseErrorMap = getResponseErrorMap(fallBackErrorCode);
    return ResponseEntity.status(fallBackErrorCode).body(responseErrorMap);
  }

  @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<HashMap<String, Object>> methodNotSupportExceptionHandler(HttpServletRequest request,
      Throwable throwable) throws Exception {
    System.out.println("============= RestFul Error =============" + " : " + new Date().getTime());

    HashMap<String, Object> responseErrorMap = getResponseErrorMap(HttpStatus.BAD_REQUEST);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseErrorMap);
  }
}
