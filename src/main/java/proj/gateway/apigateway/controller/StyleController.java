package proj.gateway.apigateway.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proj.gateway.apigateway.common.utils.HttpUtils;
import proj.gateway.apigateway.service.StyleService;

@RestController("StyleController")
public class StyleController {

  @Resource(name = "StyleService")
  private StyleService styleService;

  @GetMapping(value = "/findStyleCount")
  public String findStyleCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = styleService.findStyleCount(request);
    return HttpUtils.send(apiResponse, response);
  }

  @GetMapping(value = "/findStyle")
  public String findStyle(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = styleService.findStyle(request);
    return HttpUtils.send(apiResponse, response);
  }
  
  @DeleteMapping(value = "/removeStyle")
  public String removeStyle(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = styleService.findStyle(request);
    return HttpUtils.send(apiResponse, response);
  }
}
