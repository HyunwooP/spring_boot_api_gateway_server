package proj.gateway.apigateway.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import proj.gateway.apigateway.service.ReqeustService;

@Controller("requestController")
public class RequestController {

  @Resource(name = "requestService")
  ReqeustService requestService;

  public HashMap<String, Object> getReqeust(HttpServletRequest req) throws Exception {
    return requestService.getResponse(req);
  }

  public HashMap<String, Object> deleteReqeust(HttpServletRequest req) throws Exception {
    return requestService.deleteResponse(req);
  }

  public String postReqeust(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return requestService.postResponse(path, params, header);
  }

  public String putReqeust(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return requestService.putResponse(path, params, header);
  }

  public String patchReqeust(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return requestService.patchResponse(path, params, header);
  }
}
