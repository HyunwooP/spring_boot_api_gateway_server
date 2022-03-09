package proj.gateway.apigateway.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import proj.gateway.apigateway.common.service.CommonService;

@Service("AuthService")
public class AuthService extends CommonService {

  @CircuitBreaker(name = "signInUser", fallbackMethod = "signInUserFallBack")
  public HashMap<String, Object> signInUser(HttpServletRequest request, Map<String, Object> body) throws Exception {
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return bodyRequest(path, method, token, body);
  }

  @CircuitBreaker(name = "signInAdmin", fallbackMethod = "signInAdminFallBack")
  public HashMap<String, Object> signInAdmin(HttpServletRequest request, Map<String, Object> body) throws Exception {
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return bodyRequest(path, method, token, body);
  }

  @CircuitBreaker(name = "signOut", fallbackMethod = "signOutFallBack")
  public HashMap<String, Object> signOut(HttpServletRequest request, Map<String, Object> body) throws Exception {
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return bodyRequest(path, method, token, body);
  }

  @CircuitBreaker(name = "signUp", fallbackMethod = "signUpFallBack")
  public HashMap<String, Object> signUp(HttpServletRequest request, Map<String, Object> body) throws Exception {
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return bodyRequest(path, method, token, body);
  }

  public HashMap<String, Object> signInUserFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws Exception {
    throw new Exception(throwable.getMessage());
  }

  public HashMap<String, Object> signInAdminFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws Exception {
    throw new Exception(throwable.getMessage());
  }

  public HashMap<String, Object> signOutFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws Exception {
    throw new Exception(throwable.getMessage());
  }

  public HashMap<String, Object> signUpFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws Exception {
    throw new Exception(throwable.getMessage());
  }
}
