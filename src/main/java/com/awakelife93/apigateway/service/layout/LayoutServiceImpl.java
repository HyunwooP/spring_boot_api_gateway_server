package com.awakelife93.apigateway.service.layout;

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
public class LayoutServiceImpl implements LayoutService {

  private final HTTP http;

  @Value("${domain.designServer}")
  private String designServerDomain;

  @RateLimiter(name = "getLayoutCount")
  @CircuitBreaker(name = "getLayoutCount", fallbackMethod = "fallback")
  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException {
    try {
      String queryString = request.getQueryString();
      String url = http.generateQueryString(designServerDomain, request.getRequestURI(), queryString);
      String token = request.getHeader("authorization");

      return http.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(exception.getResponseBodyAsString());
    }
  }

  @RateLimiter(name = "getLayout")
  @CircuitBreaker(name = "getLayout", fallbackMethod = "fallback")
  public Map<String, Object> getLayout(HttpServletRequest request) throws APIResponseException {
    try {
      String url = designServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return http.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(exception.getResponseBodyAsString());
    }
  }

  @RateLimiter(name = "getLayouts")
  @CircuitBreaker(name = "getLayouts", fallbackMethod = "fallback")
  public Map<String, Object> getLayouts(HttpServletRequest request) throws APIResponseException {
    try {
      String queryString = request.getQueryString();
      String url = http.generateQueryString(designServerDomain, request.getRequestURI(), queryString);
      String token = request.getHeader("authorization");

      return http.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(exception.getResponseBodyAsString());
    }
  }

  @RateLimiter(name = "removeLayout")
  @CircuitBreaker(name = "removeLayout", fallbackMethod = "fallback")
  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException {
    try {
      String url = designServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return http.request(HttpMethod.DELETE, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(exception.getResponseBodyAsString());
    }
  }

  public Map<String, Object> fallback(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("Layout FallBack Error = " + request.getRequestURI() + " " + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

}
