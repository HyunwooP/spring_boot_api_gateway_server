package proj.gateway.apigateway.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import proj.gateway.apigateway.common.utils.HttpUtils;
import proj.gateway.apigateway.service.UserService;

@RestController("UserController")
public class UserController {

  @Resource(name = "UserService")
  private UserService userService;

  @GetMapping(value = "/findUser")
  public String findUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = userService.findUser(request);
    return HttpUtils.send(apiResponse, response);
  }

  @GetMapping(value = "/findUserCount")
  public String findUserCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = userService.findUserCount(request);
    return HttpUtils.send(apiResponse, response);
  }

  @GetMapping(value = "/findUserProfile")
  public String findUserProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = userService.findUserProfile(request);
    return HttpUtils.send(apiResponse, response);
  }

  @PatchMapping(value = "/updateUser")
  public String updateUser(HttpServletRequest request, HttpServletResponse response, Map<String, Object> body)
      throws Exception {
    HashMap<String, Object> apiResponse = userService.updateUser(request, body);
    return HttpUtils.send(apiResponse, response);
  }

  @DeleteMapping(value = "/removeUser")
  public String removeUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = userService.removeUser(request);
    return HttpUtils.send(apiResponse, response);
  }

  @DeleteMapping(value = "/tokenRemoveUser")
  public String tokenRemoveUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = userService.tokenRemoveUser(request);
    return HttpUtils.send(apiResponse, response);
  }
}
