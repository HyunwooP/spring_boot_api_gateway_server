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

  public HashMap<String, Object> postReqeust(HttpServletRequest req, Map<String, Object> body) throws Exception {
    return requestService.postResponse(req, body);
  }

  public HashMap<String, Object> putReqeust(HttpServletRequest req, Map<String, Object> body) throws Exception {
    return requestService.putResponse(req, body);
  }

  public HashMap<String, Object> patchReqeust(HttpServletRequest req, Map<String, Object> body) throws Exception {
    return requestService.patchResponse(req, body);
  }
}
