package proj.gateway.apigateway.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import proj.gateway.apigateway.common.service.CommonService;

@Service("requestService")
public class RequestService extends CommonService {

  public HashMap<String, Object> get(HttpServletRequest req) throws Exception {
    return queryRequest(req);
  }

  public HashMap<String, Object> delete(HttpServletRequest req) throws Exception {
    return queryRequest(req);
  }

  public HashMap<String, Object> post(HttpServletRequest req, Map<String, Object> body) throws Exception {
    return bodyRequest(req, body);
  }

  public HashMap<String, Object> put(HttpServletRequest req, Map<String, Object> body) throws Exception {
    return bodyRequest(req, body);
  }

  public HashMap<String, Object> patch(HttpServletRequest req, Map<String, Object> body) throws Exception {
    return bodyRequest(req, body);
  }
}
