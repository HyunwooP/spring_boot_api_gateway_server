package com.awakelife93.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.service.theme.ThemeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("themes")
@RequiredArgsConstructor
public class ThemeController {

  private final ThemeService themeService;

  @GetMapping("count")
  public Map<String, Object> getCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return themeService.getCount(request);
  }

  @GetMapping("themeItem")
  public Map<String, Object> getThemeItem(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return themeService.getThemeItem(request);
  }

  @GetMapping("{themeId}")
  public Map<String, Object> getTheme(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return themeService.getTheme(request);
  }

  @GetMapping()
  public Map<String, Object> getThemes(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return themeService.getThemes(request);
  }

  @DeleteMapping("{themeId}")
  public Map<String, Object> remove(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return themeService.remove(request);
  }
}
