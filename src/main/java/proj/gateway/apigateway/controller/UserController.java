package proj.gateway.apigateway.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import proj.gateway.apigateway.service.UserService;

@Controller("UserController")
public class UserController {

  @Resource(name = "UserService")
  private UserService userService;

  public HashMap<String, Object> findUser(HttpServletRequest request) throws Exception {
    return userService.findUser(request);
  }

  public HashMap<String, Object> findUserCount(HttpServletRequest request) throws Exception {
    return userService.findUserCount(request);
  }

  public HashMap<String, Object> findUserProfile(HttpServletRequest request) throws Exception {
    return userService.findUserProfile(request);
  }

  public HashMap<String, Object> updateUser(HttpServletRequest request, Map<String, Object> body) throws Exception {
    return userService.updateUser(request, body);
  }

  public HashMap<String, Object> removeUser(HttpServletRequest request) throws Exception {
    return userService.removeUser(request);
  }

  public HashMap<String, Object> tokenRemoveUser(HttpServletRequest request) throws Exception {
    return userService.tokenRemoveUser(request);
  }
}
