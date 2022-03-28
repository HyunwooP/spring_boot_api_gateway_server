package proj.gateway.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.ThemeService;

@RestController
@RequiredArgsConstructor
public class ThemeController {

  private final ThemeService themeService;

  @GetMapping(value = "/findThemeCount")
  public Map<String, Object> findThemeCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return themeService.findThemeCount(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findThemeItem")
  public Map<String, Object> findThemeItem(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return themeService.findThemeItem(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findTheme")
  public Map<String, Object> findTheme(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return themeService.findTheme(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @DeleteMapping(value = "/removeTheme")
  public Map<String, Object> removeTheme(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return themeService.removeTheme(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
