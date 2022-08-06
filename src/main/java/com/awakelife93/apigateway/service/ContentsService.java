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
public class ContentsService {

  private final HttpUtils httpUtils;

  @Value("${domain.apiServer}")
  private String apiServerDomain;

  @RateLimiter(name = "getContentsCount")
  @CircuitBreaker(name = "getContentsCount", fallbackMethod = "getContentsCountFallBack")
  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException {
    try {
      String queryString = request.getQueryString();
      String url = httpUtils.generateQueryString(apiServerDomain, request.getRequestURI(), queryString);
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "getContent")
  @CircuitBreaker(name = "getContent", fallbackMethod = "getContentFallBack")
  public Map<String, Object> getContent(HttpServletRequest request) throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "getContents")
  @CircuitBreaker(name = "getContents", fallbackMethod = "getContentsFallBack")
  public Map<String, Object> getContents(HttpServletRequest request) throws APIResponseException {
    try {
      String queryString = request.getQueryString();
      String url = httpUtils.generateQueryString(apiServerDomain, request.getRequestURI(), queryString);
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "createContent")
  @CircuitBreaker(name = "createContent", fallbackMethod = "createContentFallBack")
  public Map<String, Object> create(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.POST, url, token, httpUtils.generateBody(body));
    } catch (HttpClientErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "updateContent")
  @CircuitBreaker(name = "updateContent", fallbackMethod = "updateContentsFallBack")
  public Map<String, Object> update(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.POST, url, token, httpUtils.generateBody(body));
    } catch (HttpClientErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "removeContent")
  @CircuitBreaker(name = "removeContent", fallbackMethod = "removeContentFallBack")
  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.DELETE, url, token, null);
    } catch (HttpClientErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  public Map<String, Object> getContentsCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getContentsCountFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getContentFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getContentFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getContentsFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getContentsFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> createContentsFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== createContentsFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> updateContentsFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== updateContentsFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeContentFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeContentFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }
}
