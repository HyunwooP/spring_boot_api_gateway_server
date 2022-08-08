package com.awakelife93.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.service.component.ComponentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("components")
@RequiredArgsConstructor
public class ComponentController {

  private final ComponentService componentService;

  @GetMapping("count")
  public Map<String, Object> getCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return componentService.getCount(request);
  }

  @GetMapping("{componentId}")
  public Map<String, Object> getComponent(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return componentService.getComponent(request);
  }

  @GetMapping()
  public Map<String, Object> getComponents(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return componentService.getComponents(request);
  }

  @DeleteMapping("{componentId}")
  public Map<String, Object> remove(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return componentService.remove(request);
  }
}
