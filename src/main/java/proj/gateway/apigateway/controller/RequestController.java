package proj.gateway.apigateway.controller;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import proj.gateway.apigateway.service.ReqeustService;

@Controller
public class RequestController {

  @Resource(name = "requestService")
  ReqeustService requestService;

  public String getReqeust(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return requestService.getReponse(path, params, header);
  }

  public String deleteReqeust(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return requestService.deleteReponse(path, params, header);
  }

  public String postReqeust(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return requestService.postReponse(path, params, header);
  }

  public String putReqeust(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return requestService.putReponse(path, params, header);
  }

  public String patchReqeust(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return requestService.patchReponse(path, params, header);
  }
}
