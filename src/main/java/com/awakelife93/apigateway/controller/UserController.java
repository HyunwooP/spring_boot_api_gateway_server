package com.awakelife93.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.service.user.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("count")
  public Map<String, Object> getCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return userService.getCount(request);
  }

  @GetMapping("{userId}")
  public Map<String, Object> getUser(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return userService.getUser(request);
  }

  @GetMapping()
  public Map<String, Object> getUsers(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return userService.getUsers(request);
  }

  @GetMapping("profile")
  public Map<String, Object> getProfile(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return userService.getProfile(request);
  }

  @PostMapping()
  public Map<String, Object> create(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body)
      throws APIResponseException {
    return userService.create(request, body);
  }

  @PatchMapping("{userId}")
  public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body)
      throws APIResponseException {
    return userService.update(request, body);
  }

  @DeleteMapping("{userId}")
  public Map<String, Object> remove(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return userService.remove(request);
  }

  @DeleteMapping("tokenRemove")
  public Map<String, Object> tokenRemove(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return userService.tokenRemove(request);
  }
}
