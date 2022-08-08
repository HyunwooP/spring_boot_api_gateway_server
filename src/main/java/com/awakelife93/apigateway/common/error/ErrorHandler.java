package com.awakelife93.apigateway.common.error;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.awakelife93.apigateway.common.component.utils.Convert;
import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.common.error.exceptions.FallBackException;
import com.awakelife93.apigateway.common.error.exceptions.NotCertificateException;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;

@EnableWebMvc
@RequiredArgsConstructor
@RestControllerAdvice
public class ErrorHandler {

  private final Convert convert;

  private final HashMap<HttpStatus, String> errorMap = new HashMap<HttpStatus, String>() {
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

  private ErrorResponse getErrorMap(HttpStatus status) {
    ErrorResponse responseErrorMap = new ErrorResponse();

    responseErrorMap.status = status.value();
    responseErrorMap.message = getErrorMessage(status);

    return responseErrorMap;
  }

  private ErrorResponse getResponseErrorMap(String response) {
    ErrorResponse responseErrorMap = new ErrorResponse();

    try {
      Map<String, Object> responseJson = convert.jsonStringToObject(response);

      HttpStatus status = responseJson.get("status") == null ? HttpStatus.INTERNAL_SERVER_ERROR
          : HttpStatus.valueOf((int) responseJson.get("status"));

      String message = responseJson.get("message") == null ? getErrorMessage(status)
          : (String) responseJson.get("message");

      responseErrorMap.status = status.value();
      responseErrorMap.message = message;
      responseErrorMap.data = responseJson.get("data");

    } catch (JsonProcessingException exception) {

      // * In case of rate limiter case for common fallback for each model in service
      // * layer...
      boolean isRateLimit = response.contains("RateLimiter");

      responseErrorMap.status = isRateLimit ? HttpStatus.TOO_MANY_REQUESTS.value()
          : HttpStatus.INTERNAL_SERVER_ERROR.value();
      responseErrorMap.message = response;
    }

    return responseErrorMap;
  }

  @ExceptionHandler(Exception.class)
  private ResponseEntity<ErrorResponse> exceptionHandler(Throwable throwable) {
    System.out.println("============= Unknown Error =============" + " : " + new Date().getTime());
    System.out.println(throwable.getCause());
    System.out.println("=========================================");

    ErrorResponse responseErrorMap = getErrorMap(HttpStatus.INTERNAL_SERVER_ERROR);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseErrorMap);
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  private ResponseEntity<ErrorResponse> notFoundExceptionHandler(Throwable throwable) {
    System.out.println("============= NotFound Error =============" + " : " + new Date().getTime());

    ErrorResponse responseErrorMap = getErrorMap(HttpStatus.NOT_FOUND);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseErrorMap);
  }

  @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<ErrorResponse> methodNotSupportExceptionHandler(HttpServletRequest request,
      Throwable throwable) {
    System.out.println("============= RestFul Error =============" + " : " + new Date().getTime());

    ErrorResponse responseErrorMap = getErrorMap(HttpStatus.BAD_REQUEST);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseErrorMap);
  }

  @ExceptionHandler(value = NotCertificateException.class)
  public ResponseEntity<ErrorResponse> notCertificateExceptionHandler(HttpServletRequest request, Throwable throwable) {
    System.out.println("============= No Certificate Error =============" + " : " + new Date().getTime());

    ErrorResponse responseErrorMap = getErrorMap(HttpStatus.FORBIDDEN);
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseErrorMap);
  }

  // * API threads without fallback (rate limiter or circuit breaker) are handled
  // * by the corresponding Handler...
  @ExceptionHandler(APIResponseException.class)
  private ResponseEntity<ErrorResponse> apiResponseExceptionHandler(Throwable throwable) {
    System.out.println("============= API Error =============" + " : " + new Date().getTime());
    String params = throwable.getCause().getMessage();

    ErrorResponse responseErrorMap = getResponseErrorMap(params);
    return ResponseEntity.status(responseErrorMap.status).body(responseErrorMap);
  }

  // * Errors that occur in the Service Layer are caught here.
  @ExceptionHandler(FallBackException.class)
  private ResponseEntity<ErrorResponse> fallBackExceptionHandler(Throwable throwable) {
    System.out.println("============= FallBack Error =============" + " : " + new Date().getTime());
    String params = throwable.getMessage();

    ErrorResponse responseErrorMap = getResponseErrorMap(params);
    return ResponseEntity.status(responseErrorMap.status).body(responseErrorMap);
  }

}
