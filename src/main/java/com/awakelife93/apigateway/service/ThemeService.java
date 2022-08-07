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
public class ThemeService {

  private final HttpUtils httpUtils;

  @Value("${domain.designServer}")
  private String designServerDomain;

  @RateLimiter(name = "getThemeCount")
  @CircuitBreaker(name = "getThemeCount", fallbackMethod = "getThemeCountFallBack")
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

  @RateLimiter(name = "getThemeItem")
  @CircuitBreaker(name = "getThemeItem", fallbackMethod = "getThemeItemFallBack")
  public Map<String, Object> getThemeItem(HttpServletRequest request) throws APIResponseException {
    try {
      String url = designServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "getTheme")
  @CircuitBreaker(name = "getTheme", fallbackMethod = "getThemeFallBack")
  public Map<String, Object> getTheme(HttpServletRequest request) throws APIResponseException {
    try {
      String url = designServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "getThemes")
  @CircuitBreaker(name = "getThemes", fallbackMethod = "getThemesFallBack")
  public Map<String, Object> getThemes(HttpServletRequest request) throws APIResponseException {
    try {
      String queryString = request.getQueryString();
      String url = httpUtils.generateQueryString(designServerDomain, request.getRequestURI(), queryString);
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "removeTheme")
  @CircuitBreaker(name = "removeTheme", fallbackMethod = "removeThemeFallBack")
  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException {
    try {
      String url = designServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.DELETE, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  public Map<String, Object> getThemeCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getThemeCountFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getThemeItemFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getThemeItemFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getThemeFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getThemeFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getThemesFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getThemesFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeThemeFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeThemeFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }
}
