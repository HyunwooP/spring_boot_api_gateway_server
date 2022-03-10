package proj.gateway.apigateway.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proj.gateway.apigateway.common.utils.HttpUtils;
import proj.gateway.apigateway.service.LayoutService;

@RestController("LayoutController")
public class LayoutController {

  @Resource(name = "LayoutService")
  private LayoutService layoutService;

  @GetMapping(value = "/findLayoutCount")
  public String findLayoutCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = layoutService.findLayoutCount(request);
    return HttpUtils.send(apiResponse, response);
  }

  @GetMapping(value = "/findLayout")
  public String findLayout(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = layoutService.findLayout(request);
    return HttpUtils.send(apiResponse, response);
  }

  @DeleteMapping(value = "/removeLayout")
  public String removeLayout(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = layoutService.removeLayout(request);
    return HttpUtils.send(apiResponse, response);
  }
}
