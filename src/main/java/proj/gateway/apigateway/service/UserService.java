package proj.gateway.apigateway.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import proj.gateway.apigateway.common.error.APIResponseException;
import proj.gateway.apigateway.common.error.FallbackException;
import proj.gateway.apigateway.common.service.CommonService;

@Service("UserService")
public class UserService extends CommonService {

  @CircuitBreaker(name = "findUser", fallbackMethod = "findUserFallBack")
  public HashMap<String, Object> findUser(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "findUserCount", fallbackMethod = "findUserCountFallBack")
  public HashMap<String, Object> findUserCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "findUserProfile", fallbackMethod = "findUserProfileFallBack")
  public HashMap<String, Object> findUserProfile(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "updateUser", fallbackMethod = "updateUserFallBack")
  public HashMap<String, Object> updateUser(HttpServletRequest request, Map<String, Object> body) throws APIResponseException {
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");
    
    return bodyRequest(path, method, token, body);
  }

  @CircuitBreaker(name = "removeUser", fallbackMethod = "removeUserFallBack")
  public HashMap<String, Object> removeUser(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "tokenRemoveUser", fallbackMethod = "tokenRemoveUserFallBack")
  public HashMap<String, Object> tokenRemoveUser(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> findUserFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }

  public HashMap<String, Object> findUserCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }

  public HashMap<String, Object> findUserProfileFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }

  public HashMap<String, Object> updateUserFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }

  public HashMap<String, Object> removeUserFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }

  public HashMap<String, Object> tokenRemoveUserFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }
}
