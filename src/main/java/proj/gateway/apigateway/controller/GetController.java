package proj.gateway.apigateway.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import proj.gateway.apigateway.service.GetService;

@Controller
public class GetController {
  @Autowired
  private GetService getService;

  public String reqeust(String path, Map<String, String> params) throws Exception {
    return getService.response(path, params);
  }
}
