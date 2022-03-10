package proj.gateway.apigateway.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proj.gateway.apigateway.common.utils.HttpUtils;
import proj.gateway.apigateway.service.ComponentService;

@RestController("ComponentController")
public class ComponentController {

  @Resource(name = "ComponentService")
  private ComponentService componentService;

  @GetMapping(value = "/findComponentCount")
  public String findComponentCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = componentService.findComponentCount(request);
    return HttpUtils.send(apiResponse, response);
  }

  @GetMapping(value = "/findComponent")
  public String findComponent(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = componentService.findComponent(request);
    return HttpUtils.send(apiResponse, response);
  }

  @DeleteMapping(value = "removeComponent")
  public String removeComponent(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = componentService.removeComponent(request);
    return HttpUtils.send(apiResponse, response);
  }
}
