package com.awakelife93.apigateway.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import com.awakelife93.apigateway.common.component.utils.HttpUtils;
import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.common.error.exceptions.FallBackException;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final HttpUtils httpUtils;

  @Value("${domain.apiServer}")
  private String apiServerDomain;

  @RateLimiter(name = "signIn")
  @CircuitBreaker(name = "signIn", fallbackMethod = "signInFallBack")
  public Map<String, Object> signIn(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.POST, url, token, httpUtils.generateBody(body));
    } catch (HttpClientErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "signOut")
  @CircuitBreaker(name = "signOut", fallbackMethod = "signOutFallBack")
  public Map<String, Object> signOut(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.POST, url, token, httpUtils.generateBody(body));
    } catch (HttpClientErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  public Map<String, Object> signInFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== signInFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> signOutFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== signOutFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }
}
