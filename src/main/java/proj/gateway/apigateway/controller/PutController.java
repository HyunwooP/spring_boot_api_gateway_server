package proj.gateway.apigateway.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import proj.gateway.apigateway.service.PutService;

/**
 * Put 컨트롤러
 */
@Controller
public class PutController {
  @Autowired
  private PutService putService;

  public String reqeust(String path, Map<String, String> params) throws Exception {
    return putService.response(path, params);
  }
}
