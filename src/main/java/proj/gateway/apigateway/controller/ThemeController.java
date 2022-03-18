package proj.gateway.apigateway.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.component.utils.HttpUtils;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.ThemeService;

@RestController
@RequiredArgsConstructor
public class ThemeController {

  private final ThemeService themeService;

  @GetMapping(value = "/findThemeCount")
  public String findThemeCount(HttpServletRequest request, HttpServletResponse response) throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = themeService.findThemeCount(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findThemeItem")
  public String findThemeItem(HttpServletRequest request, HttpServletResponse response) throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = themeService.findThemeItem(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findTheme")
  public String findTheme(HttpServletRequest request, HttpServletResponse response) throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = themeService.findTheme(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @DeleteMapping(value = "/removeTheme")
  public String removeTheme(HttpServletRequest request, HttpServletResponse response) throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = themeService.removeTheme(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
