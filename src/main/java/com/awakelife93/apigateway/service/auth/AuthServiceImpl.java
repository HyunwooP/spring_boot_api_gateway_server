package com.awakelife93.apigateway.service.auth;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.awakelife93.apigateway.common.component.utils.HTTP;
import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.common.error.exceptions.FallBackException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final HTTP http;

  @Value("${domain.apiServer}")
  private String apiServerDomain;

  @RateLimiter(name = "signIn")
  @CircuitBreaker(name = "signIn", fallbackMethod = "bodyFallBack")
  public Map<String, Object> signIn(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return http.request(HttpMethod.POST, url, token,
          http.generateBody(body));
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(exception.getResponseBodyAsString());
    }
  }

  @RateLimiter(name = "signOut")
  @CircuitBreaker(name = "signOut", fallbackMethod = "bodyFallBack")
  public Map<String, Object> signOut(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return http.request(HttpMethod.POST, url, token,
          http.generateBody(body));
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(exception.getResponseBodyAsString());
    }
  }

  public Map<String, Object> bodyFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("Auth BodyFallBack Error = " + request.getRequestURI() + " " + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

}
