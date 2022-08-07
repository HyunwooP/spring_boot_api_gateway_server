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
public class CommonModelService {

  private final HttpUtils httpUtils;

  @Value("${domain.apiServer}")
  private String apiServerDomain;

  @Value("${domain.designServer}")
  private String designServerDomain;

  @RateLimiter(name = "getClientHealth")
  @CircuitBreaker(name = "getClientHealth", fallbackMethod = "getClientHealthFallBack")
  public Map<String, Object> getClientHealth(HttpServletRequest request) throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "getDesignHealth")
  @CircuitBreaker(name = "getDesignHealth", fallbackMethod = "getDesignHealthFallBack")
  public Map<String, Object> getDesignHealth(HttpServletRequest request) throws APIResponseException {
    try {
      String url = designServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "getDashboardCount")
  @CircuitBreaker(name = "getDashboardCount", fallbackMethod = "getDashboardCountFallBack")
  public Map<String, Object> getDashboardCount(HttpServletRequest request) throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  public Map<String, Object> getClientHealthFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getClientHealthFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getDesignHealthFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getDesignHealthFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getDashboardCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getDashboardCountFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }
}
