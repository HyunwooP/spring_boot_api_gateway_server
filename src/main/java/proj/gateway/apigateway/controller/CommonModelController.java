package proj.gateway.apigateway.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proj.gateway.apigateway.common.utils.HttpUtils;
import proj.gateway.apigateway.service.CommonModelService;

@RestController("CommonModelController")
public class CommonModelController {

  @Resource(name = "CommonModelService")
  private CommonModelService commonModelService;

  @GetMapping(value = "/clientHealth")
  public String clientHealth(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = commonModelService.clientHealth(request);
    return HttpUtils.send(apiResponse, response);
  }

  @GetMapping(value = "/designHealth")
  public String designHealth(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = commonModelService.designHealth(request);
    return HttpUtils.send(apiResponse, response);
  }

  @GetMapping(value = "/findDashboardCount")
  public String findDashboardCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HashMap<String, Object> apiResponse = commonModelService.findDashboardCount(request);
    return HttpUtils.send(apiResponse, response);
  }
}
