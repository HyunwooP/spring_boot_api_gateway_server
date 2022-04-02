package proj.gateway.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.ThemeService;

@RestController
@RequestMapping("themes")
@RequiredArgsConstructor
public class ThemeController {

  private final ThemeService themeService;

  @GetMapping(value = "/getCount")
  public Map<String, Object> getCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return themeService.getCount(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping("/getThemeItem")
  public Map<String, Object> getThemeItem(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return themeService.getThemeItem(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping("/{themeId}")
  public Map<String, Object> getTheme(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return themeService.getTheme(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping()
  public Map<String, Object> getThemes(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return themeService.getThemes(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @DeleteMapping("/{themeId}")
  public Map<String, Object> remove(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return themeService.remove(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
