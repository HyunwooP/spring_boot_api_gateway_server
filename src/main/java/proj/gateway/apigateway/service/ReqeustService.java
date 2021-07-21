package proj.gateway.apigateway.service;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import proj.gateway.apigateway.common.service.CommonService;

@Service("requestService")
public class ReqeustService extends CommonService {

  public HashMap<String, Object> getResponse(HttpServletRequest req) throws Exception {
    return queryRequest(req);
  }

  public HashMap<String, Object> deleteResponse(HttpServletRequest req) throws Exception {
    return queryRequest(req);
  }

  public HashMap<String, Object> postResponse(HttpServletRequest req, Map<String, Object> body)
      throws Exception {
    return bodyRequest(req, body);
  }

  public HashMap<String, Object> putResponse(HttpServletRequest req, Map<String, Object> body)
      throws Exception {
    return bodyRequest(req, body);
  }

  public HashMap<String, Object> patchResponse(HttpServletRequest req, Map<String, Object> body)
      throws Exception {
    return bodyRequest(req, body);
  }
}
