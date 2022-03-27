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
public class AuthService {

  private final HttpModule httpModule;

  @CircuitBreaker(name = "signInUser", fallbackMethod = "signInUserFallBack")
  public Map<String, Object> signInUser(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.postRequest(path, token, body);
  }

  @CircuitBreaker(name = "signInAdmin", fallbackMethod = "signInAdminFallBack")
  public Map<String, Object> signInAdmin(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.postRequest(path, token, body);
  }

  @CircuitBreaker(name = "signOut", fallbackMethod = "signOutFallBack")
  public Map<String, Object> signOut(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.postRequest(path, token, body);
  }

  public Map<String, Object> signInUserFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== signInUserFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> signInAdminFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== signInAdminFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> signOutFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== signOutFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }
}
