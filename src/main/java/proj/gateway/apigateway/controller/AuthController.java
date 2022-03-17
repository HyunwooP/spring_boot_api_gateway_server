package proj.gateway.apigateway.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.common.utils.HttpUtils;
import proj.gateway.apigateway.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping(value = "/signInUser")
  public String signInUser(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body) throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = authService.signInUser(request, body);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @PostMapping(value = "/signInAdmin")
  public String signInAdmin(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body) throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = authService.signInAdmin(request, body);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @PostMapping(value = "/signOut")
  public String signOut(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> body)
      throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = authService.signOut(request, body);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @PostMapping(value = "/signUp")
  public String signUp(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> body)
      throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = authService.signUp(request, body);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
