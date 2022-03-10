package proj.gateway.apigateway.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proj.gateway.apigateway.common.utils.HttpUtils;
import proj.gateway.apigateway.service.ThemeService;

@RestController("ThemeController")
public class ThemeController {

  @Resource(name = "ThemeService")
  private ThemeService themeService;

  @GetMapping(value = "/findThemeCount")
  public String findThemeCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = themeService.findThemeCount(request);
    return HttpUtils.send(apiResponse, response);
  }

  @GetMapping(value = "/findThemeItem")
  public String findThemeItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = themeService.findThemeItem(request);
    return HttpUtils.send(apiResponse, response);
  }

  @GetMapping(value = "/findTheme")
  public String findTheme(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = themeService.findTheme(request);
    return HttpUtils.send(apiResponse, response);
  }

  @DeleteMapping(value = "/removeTheme")
  public String removeTheme(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = themeService.removeTheme(request);
    return HttpUtils.send(apiResponse, response);
  }
}
