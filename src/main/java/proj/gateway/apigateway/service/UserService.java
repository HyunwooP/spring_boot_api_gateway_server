package proj.gateway.apigateway.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
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

  @Value("${domain.apiServer}")
  private String apiServerDomain;

  @CircuitBreaker(name = "getUserCount", fallbackMethod = "getUserCountFallBack")
  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String url = apiServerDomain + request.getRequestURI() + (queryString != null ? "?" + queryString : "");
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getUser", fallbackMethod = "getUserFallBack")
  public Map<String, Object> getUser(HttpServletRequest request) throws APIResponseException {
    String url = apiServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getUsers", fallbackMethod = "getUsersFallBack")
  public Map<String, Object> getUsers(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String url = apiServerDomain + request.getRequestURI() + (queryString != null ? "?" + queryString : "");
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getProfile", fallbackMethod = "getProfileFallBack")
  public Map<String, Object> getProfile(HttpServletRequest request) throws APIResponseException {
    String url = apiServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "createUser", fallbackMethod = "createUserFallBack")
  public Map<String, Object> create(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    String url = apiServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.postRequest(url, token, body);
  }

  @CircuitBreaker(name = "updateUser", fallbackMethod = "updateUserFallBack")
  public Map<String, Object> update(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    String url = apiServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.patchRequest(url, token, body);
  }

  @CircuitBreaker(name = "removeUser", fallbackMethod = "removeUserFallBack")
  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException {
    String url = apiServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.deleteRequest(url, token);
  }

  @CircuitBreaker(name = "tokenRemoveUser", fallbackMethod = "tokenRemoveUserFallBack")
  public Map<String, Object> tokenRemove(HttpServletRequest request) throws APIResponseException {
    String url = apiServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.deleteRequest(url, token);
  }

  public Map<String, Object> getUserCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getUserCountFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getUserFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getUserFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getUsersFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getUsersFallBack ==============");
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
