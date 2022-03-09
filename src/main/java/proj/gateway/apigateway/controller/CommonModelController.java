package proj.gateway.apigateway.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import proj.gateway.apigateway.service.CommonModelService;

@Controller("CommonModelController")
public class CommonModelController {

  @Resource(name = "CommonModelService")
  private CommonModelService commonModelService;

  public HashMap<String, Object> clientHealth(HttpServletRequest request) throws Exception {
    return commonModelService.clientHealth(request);
  }

  public HashMap<String, Object> designHealth(HttpServletRequest request) throws Exception {
    return commonModelService.designHealth(request);
  }

  public HashMap<String, Object> findDashboardCount(HttpServletRequest request) throws Exception {
    return commonModelService.findDashboardCount(request);
  }
}
