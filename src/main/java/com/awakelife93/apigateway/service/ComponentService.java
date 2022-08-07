package com.awakelife93.apigateway.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.awakelife93.apigateway.common.component.utils.HttpUtils;
import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.common.error.exceptions.FallBackException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComponentService {

  private final HttpUtils httpUtils;

  @Value("${domain.designServer}")
  private String designServerDomain;

  @RateLimiter(name = "getComponentCount")
  @CircuitBreaker(name = "getComponentCount", fallbackMethod = "getComponentCountFallBack")
  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException {
    try {
      String queryString = request.getQueryString();
      String url = httpUtils.generateQueryString(designServerDomain, request.getRequestURI(), queryString);
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "getComponent")
  @CircuitBreaker(name = "getComponent", fallbackMethod = "getComponentFallBack")
  public Map<String, Object> getComponent(HttpServletRequest request) throws APIResponseException {
    try {
      String url = designServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "getComponents")
  @CircuitBreaker(name = "getComponents", fallbackMethod = "getComponentsFallBack")
  public Map<String, Object> getComponents(HttpServletRequest request) throws APIResponseException {
    try {
      String queryString = request.getQueryString();
      String url = httpUtils.generateQueryString(designServerDomain, request.getRequestURI(), queryString);
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "removeComponent")
  @CircuitBreaker(name = "removeComponent", fallbackMethod = "removeComponentFallBack")
  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException {
    try {
      String url = designServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.DELETE, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  public Map<String, Object> getComponentCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getComponentCountFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getComponentFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getComponentFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getComponentsFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getComponentsFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeComponentFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeComponentFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }
}
