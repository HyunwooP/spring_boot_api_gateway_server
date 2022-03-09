package proj.gateway.apigateway.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import proj.gateway.apigateway.service.StyleService;

@Controller("StyleController")
public class StyleController {

  @Resource(name = "StyleService")
  private StyleService styleService;

  public HashMap<String, Object> findStyleCount(HttpServletRequest request) throws Exception {
    return styleService.findStyleCount(request);
  }

  public HashMap<String, Object> findStyle(HttpServletRequest request) throws Exception {
    return styleService.findStyle(request);
  }

  public HashMap<String, Object> removeStyle(HttpServletRequest request) throws Exception {
    return styleService.removeStyle(request);
  }
}
