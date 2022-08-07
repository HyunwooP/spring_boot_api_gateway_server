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
public class UserService {

  private final HttpUtils httpUtils;

  @Value("${domain.apiServer}")
  private String apiServerDomain;

  @RateLimiter(name = "getUserCount")
  @CircuitBreaker(name = "getUserCount", fallbackMethod = "getUserCountFallBack")
  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException {
    try {
      String queryString = request.getQueryString();
      String url = httpUtils.generateQueryString(apiServerDomain, request.getRequestURI(), queryString);
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "getUser")
  @CircuitBreaker(name = "getUser", fallbackMethod = "getUserFallBack")
  public Map<String, Object> getUser(HttpServletRequest request) throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "getUsers")
  @CircuitBreaker(name = "getUsers", fallbackMethod = "getUsersFallBack")
  public Map<String, Object> getUsers(HttpServletRequest request) throws APIResponseException {
    try {
      String queryString = request.getQueryString();
      String url = httpUtils.generateQueryString(apiServerDomain, request.getRequestURI(), queryString);
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "getProfile")
  @CircuitBreaker(name = "getProfile", fallbackMethod = "getProfileFallBack")
  public Map<String, Object> getProfile(HttpServletRequest request) throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.GET, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "createUser")
  @CircuitBreaker(name = "createUser", fallbackMethod = "createUserFallBack")
  public Map<String, Object> create(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.POST, url, token, httpUtils.generateBody(body));
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "updateUser")
  @CircuitBreaker(name = "updateUser", fallbackMethod = "updateUserFallBack")
  public Map<String, Object> update(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.PATCH, url, token, httpUtils.generateBody(body));
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "removeUser")
  @CircuitBreaker(name = "removeUser", fallbackMethod = "removeUserFallBack")
  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.DELETE, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  @RateLimiter(name = "tokenRemoveUser")
  @CircuitBreaker(name = "tokenRemoveUser", fallbackMethod = "tokenRemoveUserFallBack")
  public Map<String, Object> tokenRemove(HttpServletRequest request) throws APIResponseException {
    try {
      String url = apiServerDomain + request.getRequestURI();
      String token = request.getHeader("authorization");

      return httpUtils.request(HttpMethod.DELETE, url, token, null);
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIResponseException(Integer.toString(exception.getRawStatusCode()));
    }
  }

  public Map<String, Object> getUserCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getUserCountFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getUserFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getUserFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getUsersFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getUsersFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getProfileFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getProfileFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> createUserFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== createUserFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> updateUserFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== updateUserFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeUserFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeUserFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> tokenRemoveUserFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== tokenRemoveUserFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }
}
