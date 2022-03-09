package proj.gateway.apigateway.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import proj.gateway.apigateway.service.AuthService;
import proj.gateway.apigateway.service.ComponentService;
import proj.gateway.apigateway.service.ContentsService;
import proj.gateway.apigateway.service.LayoutService;
import proj.gateway.apigateway.service.StyleService;
import proj.gateway.apigateway.service.ThemeService;
import proj.gateway.apigateway.service.UserService;

@Controller("RequestController")
public class RequestController {

  @Resource(name = "UserService")
  UserService userService;

  @Resource(name = "AuthService")
  AuthService authService;

  @Resource(name = "ContentsService")
  ContentsService contentsService;

  @Resource(name = "ComponentService")
  ComponentService componentService;

  @Resource(name = "LayoutService")
  LayoutService layoutService;

  @Resource(name = "StyleService")
  StyleService styleService;

  @Resource(name = "ThemeService")
  ThemeService themeService;

  public HashMap<String, Object> get(HttpServletRequest req) throws Exception {
    String path = req.getRequestURI();

    switch (path) {
      case "/findUser":
        return userService.findUser(req);
      case "/findUserCount":
        return userService.findUserCount(req);
      case "/findUserProfile":
        return userService.findUserProfile(req);
      case "/findContentsCount":
        return contentsService.findContentsCount(req);
      case "/findContents":
        return contentsService.findContents(req);
      case "/findComponentCount":
        return componentService.findComponentCount(req);
      case "/findComponent":
        return componentService.findComponent(req);
      case "/findLayoutCount":
        return layoutService.findLayoutCount(req);
      case "/findLayout":
        return layoutService.findLayout(req);
      case "/findStyleCount":
        return styleService.findStyleCount(req);
      case "/findStyle":
        return styleService.findStyle(req);
      case "/findThemeCount":
        return themeService.findThemeCount(req);
      case "/findThemeItem":
        return themeService.findThemeItem(req);
      case "/findTheme":
        return themeService.findTheme(req);

      default:
        throw new Error("That API doesn't exist.");
    }
  }

  public HashMap<String, Object> post(HttpServletRequest req, Map<String, Object> body) throws Exception {
    String path = req.getRequestURI();

    switch (path) {
      case "/signInUser":
        return authService.signInUser(req, body);
      case "/signInAdmin":
        return authService.signInAdmin(req, body);
      case "/signUp":
        return authService.signUp(req, body);
      case "/signOut":
        return authService.signOut(req, body);
      case "/createContents":
        return contentsService.createContents(req, body);

      default:
        throw new Error("That API doesn't exist.");
    }
  }

  public HashMap<String, Object> delete(HttpServletRequest req) throws Exception {
    String path = req.getRequestURI();

    switch (path) {
      case "/removeUser":
        return userService.removeUser(req);
      case "/tokenRemoveUser":
        return userService.tokenRemoveUser(req);
      case "/removeContents":
        return contentsService.removeContents(req);
      case "/removeComponent":
        return componentService.removeComponent(req);
      case "/removeLayout":
        return layoutService.removeLayout(req);
      case "/removeStyle":
        return styleService.removeStyle(req);
      case "/removeTheme":
        return themeService.removeTheme(req);

      default:
        throw new Error("That API doesn't exist.");
    }
  }

  public HashMap<String, Object> put(HttpServletRequest req, Map<String, Object> body) throws Exception {
    String path = req.getRequestURI();

    switch (path) {
      default:
        throw new Error("That API doesn't exist.");
    }
  }

  public HashMap<String, Object> patch(HttpServletRequest req, Map<String, Object> body) throws Exception {
    String path = req.getRequestURI();

    switch (path) {
      case "/updateUser":
        return userService.updateUser(req, body);
      case "/updateContents":
        return contentsService.updateContents(req, body);

      default:
        throw new Error("That API doesn't exist.");
    }
  }
}
