package proj.gateway.apigateway.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import proj.gateway.apigateway.service.AuthService;

@Controller("AuthController")
public class AuthController {

  @Resource(name = "AuthService")
  private AuthService authService;

  public HashMap<String, Object> signInUser(HttpServletRequest request, Map<String, Object> body) throws Exception {
    return authService.signInUser(request, body);
  }

  public HashMap<String, Object> signInAdmin(HttpServletRequest request, Map<String, Object> body) throws Exception {
    return authService.signInAdmin(request, body);
  }

  public HashMap<String, Object> signOut(HttpServletRequest request, Map<String, Object> body) throws Exception {
    return authService.signOut(request, body);
  }

  @CircuitBreaker(name = "signUp", fallbackMethod = "signUpFallBack")
  public HashMap<String, Object> signUp(HttpServletRequest request, Map<String, Object> body) throws Exception {
    return authService.signUp(request, body);
  }
}
