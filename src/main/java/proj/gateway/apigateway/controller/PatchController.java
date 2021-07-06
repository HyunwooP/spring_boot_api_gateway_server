package proj.gateway.apigateway.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import proj.gateway.apigateway.service.PatchService;

/**
 * Patch 컨트롤러
 */
@Controller
public class PatchController {
  @Autowired
  private PatchService patchService;

  public String reqeust(String path, Map<String, String> params) throws Exception {
    return patchService.response(path, params);
  }
}
