package com.awakelife93.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.service.layout.LayoutService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("layouts")
@RequiredArgsConstructor
public class LayoutController {

  private final LayoutService layoutService;

  @GetMapping("count")
  public Map<String, Object> getCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return layoutService.getCount(request);
  }

  @GetMapping("{layoutId}")
  public Map<String, Object> getLayout(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return layoutService.getLayout(request);
  }

  @GetMapping()
  public Map<String, Object> getLayouts(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return layoutService.getLayouts(request);
  }

  @DeleteMapping("{layoutId}")
  public Map<String, Object> remove(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return layoutService.remove(request);
  }
}
