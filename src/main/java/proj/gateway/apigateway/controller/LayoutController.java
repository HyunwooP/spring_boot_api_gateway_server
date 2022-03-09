package proj.gateway.apigateway.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import proj.gateway.apigateway.service.LayoutService;

@Controller("LayoutController")
public class LayoutController {

  @Resource(name = "LayoutService")
  private LayoutService layoutService;

  public HashMap<String, Object> findLayoutCount(HttpServletRequest request) throws Exception {
    return layoutService.findLayoutCount(request);
  }

  public HashMap<String, Object> findLayout(HttpServletRequest request) throws Exception {
    return layoutService.findLayout(request);
  }

  public HashMap<String, Object> removeLayout(HttpServletRequest request) throws Exception {
    return layoutService.removeLayout(request);
  }
}
