package proj.gateway.apigateway;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import proj.gateway.apigateway.controller.AuthController;
import proj.gateway.apigateway.controller.CommonModelController;
import proj.gateway.apigateway.controller.ComponentController;
import proj.gateway.apigateway.controller.ContentsController;
import proj.gateway.apigateway.controller.LayoutController;
import proj.gateway.apigateway.controller.StyleController;
import proj.gateway.apigateway.controller.ThemeController;
import proj.gateway.apigateway.controller.UserController;

@RestController
public class Request {

  @Resource(name = "UserController")
  private UserController userController;

  @Resource(name = "AuthController")
  private AuthController authController;

  @Resource(name = "ContentsController")
  private ContentsController contentsController;

  @Resource(name = "ComponentController")
  private ComponentController componentController;

  @Resource(name = "LayoutController")
  private LayoutController layoutController;

  @Resource(name = "StyleController")
  private StyleController styleController;

  @Resource(name = "ThemeController")
  private ThemeController themeController;

  @Resource(name = "CommonModelController")
  private CommonModelController commonModelController;

  private String send(HashMap<String, Object> apiResponse, HttpServletResponse response) {
    if (apiResponse == null) {
      throw new Error("Empty Api Response.");
    }

    int status = (int) apiResponse.get("status");
    String jsonString = (String) apiResponse.get("data");

    response.setStatus(status);
    return jsonString;
  };

  @RequestMapping(value = { "/{path}", "/{path}/" }, method = RequestMethod.GET)
  private String get(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String path = request.getRequestURI();
    HashMap<String, Object> apiResponse = null;

    switch (path) {
      case "/findUser":
        apiResponse = userController.findUser(request);
      case "/findUserCount":
        apiResponse = userController.findUserCount(request);
      case "/findUserProfile":
        apiResponse = userController.findUserProfile(request);
      case "/findContentsCount":
        apiResponse = contentsController.findContentsCount(request);
      case "/findContents":
        apiResponse = contentsController.findContents(request);
      case "/findComponentCount":
        apiResponse = componentController.findComponentCount(request);
      case "/findComponent":
        apiResponse = componentController.findComponent(request);
      case "/findLayoutCount":
        apiResponse = layoutController.findLayoutCount(request);
      case "/findLayout":
        apiResponse = layoutController.findLayout(request);
      case "/findStyleCount":
        apiResponse = styleController.findStyleCount(request);
      case "/findStyle":
        apiResponse = styleController.findStyle(request);
      case "/findThemeCount":
        apiResponse = themeController.findThemeCount(request);
      case "/findThemeItem":
        apiResponse = themeController.findThemeItem(request);
      case "/findTheme":
        apiResponse = themeController.findTheme(request);
    }

    return send(apiResponse, response);
  }

  @RequestMapping(value = { "/{path}", "/{path}/" }, method = RequestMethod.DELETE)
  private String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String path = request.getRequestURI();
    HashMap<String, Object> apiResponse = null;

    switch (path) {
      case "/removeUser":
        apiResponse = userController.removeUser(request);
      case "/tokenRemoveUser":
        apiResponse = userController.tokenRemoveUser(request);
      case "/removeContents":
        apiResponse = contentsController.removeContents(request);
      case "/removeComponent":
        apiResponse = componentController.removeComponent(request);
      case "/removeLayout":
        apiResponse = layoutController.removeLayout(request);
      case "/removeStyle":
        apiResponse = styleController.removeStyle(request);
      case "/removeTheme":
        apiResponse = themeController.removeTheme(request);
    }

    return send(apiResponse, response);
  }

  @RequestMapping(value = { "/{path}" }, method = RequestMethod.POST)
  private String post(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> body)
      throws Exception {
    String path = request.getRequestURI();
    HashMap<String, Object> apiResponse = null;

    switch (path) {
      case "/signInUser":
        apiResponse = authController.signInUser(request, body);
      case "/signInAdmin":
        apiResponse = authController.signInAdmin(request, body);
      case "/signUp":
        apiResponse = authController.signUp(request, body);
      case "/signOut":
        apiResponse = authController.signOut(request, body);
      case "/createContents":
        apiResponse = contentsController.createContents(request, body);
    }

    return send(apiResponse, response);
  }

  @RequestMapping(value = { "/{path}" }, method = RequestMethod.PUT)
  private String put(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> body)
      throws Exception {
    String path = request.getRequestURI();
    HashMap<String, Object> apiResponse = null;
    return send(apiResponse, response);
  }

  @RequestMapping(value = { "/{path}" }, method = RequestMethod.PATCH)
  private String patch(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> body)
      throws Exception {
    String path = request.getRequestURI();
    HashMap<String, Object> apiResponse = null;

    switch (path) {
      case "/updateUser":
        apiResponse = userController.updateUser(request, body);
      case "/updateContents":
        apiResponse = contentsController.updateContents(request, body);
    }

    return send(apiResponse, response);
  }
}
