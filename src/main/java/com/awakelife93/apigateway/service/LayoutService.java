package com.awakelife93.apigateway.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import com.awakelife93.apigateway.common.component.utils.HttpUtils;
import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.common.error.exceptions.FallBackException;

@Service
@RequiredArgsConstructor
public class LayoutService {

  private final HttpUtils httpUtils;

  @Value("${domain.designServer}")
  private String designServerDomain;

  @RateLimiter(name = "getLayoutCount")
  @CircuitBreaker(name = "getLayoutCount", fallbackMethod = "getLayoutCountFallBack")
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

  @RateLimiter(name = "getLayout")
  @CircuitBreaker(name = "getLayout", fallbackMethod = "getLayoutFallBack")
  public Map<String, Object> getLayout(HttpServletRequest request) throws APIResponseException {
    try {
      String url = designServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "getLayouts")
  @CircuitBreaker(name = "getLayouts", fallbackMethod = "getLayoutsFallBack")
  public Map<String, Object> getLayouts(HttpServletRequest request) throws APIResponseException {
    try {
      String queryString = request.getQueryString();
      String url = httpUtils.generateQueryString(designServerDomain, request.getRequestURI(), queryString);
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "removeLayout")
  @CircuitBreaker(name = "removeLayout", fallbackMethod = "removeLayoutFallBack")
  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException {
    try {
      String url = designServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.DELETE, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  public Map<String, Object> getLayoutCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getLayoutCountFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getLayoutFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getLayoutFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getLayoutsFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getLayoutsFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeLayoutFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeLayoutFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }
}
