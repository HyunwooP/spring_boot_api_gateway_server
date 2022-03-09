package proj.gateway.apigateway.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import proj.gateway.apigateway.service.ComponentService;

@Controller("ComponentController")
public class ComponentController {

  @Resource(name = "ComponentService")
  private ComponentService componentService;

  public HashMap<String, Object> findComponentCount(HttpServletRequest request) throws Exception {
    return componentService.findComponentCount(request);
  }

  public HashMap<String, Object> findComponent(HttpServletRequest request) throws Exception {
    return componentService.findComponent(request);
  }

  public HashMap<String, Object> removeComponent(HttpServletRequest request) throws Exception {
    return componentService.removeComponent(request);
  }
}
