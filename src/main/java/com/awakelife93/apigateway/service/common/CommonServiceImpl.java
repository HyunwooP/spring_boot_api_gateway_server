package com.awakelife93.apigateway.service.common;

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
public class CommonServiceImpl implements CommonService {

  private final HTTP http;

  @Value("${domain.apiServer}")
  private String apiServerDomain;

  @Value("${domain.designServer}")
  private String designServerDomain;

  @RateLimiter(name = "getClientHealth")
  @CircuitBreaker(name = "getClientHealth", fallbackMethod = "fallback")
  public Map<String, Object> getClientHealth(HttpServletRequest request) throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return http.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(exception.getResponseBodyAsString());
    }
  }

  @RateLimiter(name = "getDesignHealth")
  @CircuitBreaker(name = "getDesignHealth", fallbackMethod = "fallback")
  public Map<String, Object> getDesignHealth(HttpServletRequest request) throws APIResponseException {
    try {
      String url = designServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return http.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(exception.getResponseBodyAsString());
    }
  }

  @RateLimiter(name = "getDashboardCount")
  @CircuitBreaker(name = "getDashboardCount", fallbackMethod = "fallback")
  public Map<String, Object> getDashboardCount(HttpServletRequest request) throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return http.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(exception.getResponseBodyAsString());
    }
  }

  public Map<String, Object> fallback(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("Common FallBack Error = " + request.getRequestURI() + " " + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

}
