package proj.gateway.apigateway.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import proj.gateway.apigateway.service.ThemeService;

@Controller("ThemeController")
public class ThemeController {

  @Resource(name = "ThemeService")
  private ThemeService themeService;

  public HashMap<String, Object> findThemeCount(HttpServletRequest request) throws Exception {
    return themeService.findThemeCount(request);
  }

  public HashMap<String, Object> findThemeItem(HttpServletRequest request) throws Exception {
    return themeService.findThemeItem(request);
  }

  public HashMap<String, Object> findTheme(HttpServletRequest request) throws Exception {
    return themeService.findTheme(request);
  }

  public HashMap<String, Object> removeTheme(HttpServletRequest request) throws Exception {
    return themeService.removeTheme(request);
  }
}
