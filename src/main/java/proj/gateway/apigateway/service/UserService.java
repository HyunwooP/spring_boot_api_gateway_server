package proj.gateway.apigateway.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.component.HttpModule;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.common.error.exceptions.FallBackException;

@Service
@RequiredArgsConstructor
public class UserService {

  private final HttpModule httpModule;

  @CircuitBreaker(name = "findUser", fallbackMethod = "findUserFallBack")
  public Map<String, Object> findUser(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "findUserCount", fallbackMethod = "findUserCountFallBack")
  public Map<String, Object> findUserCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "findUserProfile", fallbackMethod = "findUserProfileFallBack")
  public Map<String, Object> findUserProfile(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "createUser", fallbackMethod = "createUserFallBack")
  public Map<String, Object> createUser(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.postRequest(path, token, body);
  }

  @CircuitBreaker(name = "updateUser", fallbackMethod = "updateUserFallBack")
  public Map<String, Object> updateUser(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.patchRequest(path, token, body);
  }

  @CircuitBreaker(name = "removeUser", fallbackMethod = "removeUserFallBack")
  public Map<String, Object> removeUser(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.deleteRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "tokenRemoveUser", fallbackMethod = "tokenRemoveUserFallBack")
  public Map<String, Object> tokenRemoveUser(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.deleteRequest(queryString, path, token);
  }

  public Map<String, Object> findUserFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findUserFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> findUserCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findUserCountFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> findUserProfileFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findUserProfileFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> createUserFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== createUserFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> updateUserFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== updateUserFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeUserFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeUserFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> tokenRemoveUserFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== tokenRemoveUserFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }
}
