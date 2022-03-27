package proj.gateway.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.component.utils.HttpUtils;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping(value = "/findUser")
  public Map<String, Object> findUser(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      Map<String, Object> apiResponse = userService.findUser(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findUserCount")
  public Map<String, Object> findUserCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      Map<String, Object> apiResponse = userService.findUserCount(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findUserProfile")
  public Map<String, Object> findUserProfile(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      Map<String, Object> apiResponse = userService.findUserProfile(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @PostMapping(value = "/createUser")
  public Map<String, Object> createUser(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body)
      throws APIResponseException {
    try {
      Map<String, Object> apiResponse = userService.createUser(request, body);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException e) {
      throw new APIResponseException(e.getMessage());
    }
  }

  @PatchMapping(value = "/updateUser")
  public Map<String, Object> updateUser(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body)
      throws APIResponseException {
    try {
      Map<String, Object> apiResponse = userService.updateUser(request, body);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException e) {
      throw new APIResponseException(e.getMessage());
    }
  }

  @DeleteMapping(value = "/removeUser")
  public Map<String, Object> removeUser(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      Map<String, Object> apiResponse = userService.removeUser(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @DeleteMapping(value = "/tokenRemoveUser")
  public Map<String, Object> tokenRemoveUser(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      Map<String, Object> apiResponse = userService.tokenRemoveUser(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
