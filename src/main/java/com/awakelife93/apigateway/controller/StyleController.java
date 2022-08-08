package com.awakelife93.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.service.style.StyleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("styles")
@RequiredArgsConstructor
public class StyleController {

  private final StyleService styleService;

  @GetMapping("count")
  public Map<String, Object> getCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return styleService.getCount(request);
  }

  @GetMapping("{styleId}")
  public Map<String, Object> getStyle(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return styleService.getStyle(request);
  }

  @GetMapping()
  public Map<String, Object> getStyles(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return styleService.getStyles(request);
  }

  @DeleteMapping("{styleId}")
  public Map<String, Object> remove(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return styleService.remove(request);
  }
}
