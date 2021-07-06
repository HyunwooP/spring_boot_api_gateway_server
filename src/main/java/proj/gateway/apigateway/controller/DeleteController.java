package proj.gateway.apigateway.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import proj.gateway.apigateway.service.DeleteService;

/**
 * Delete 컨트롤러
 */
@Controller
public class DeleteController {
  @Autowired
  private DeleteService deleteService;

  public String reqeust(String path, Map<String, String> params) throws Exception {
    return deleteService.response(path, params);
  }
}
