package proj.gateway.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping(value = "/signInUser")
  public Map<String, Object> signInUser(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body) throws APIResponseException {
    try {
      return authService.signInUser(request, body);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @PostMapping(value = "/signInAdmin")
  public Map<String, Object> signInAdmin(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body) throws APIResponseException {
    try {
      return authService.signInAdmin(request, body);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @PostMapping(value = "/signOut")
  public Map<String, Object> signOut(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body)
      throws APIResponseException {
    try {
      return authService.signOut(request, body);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
