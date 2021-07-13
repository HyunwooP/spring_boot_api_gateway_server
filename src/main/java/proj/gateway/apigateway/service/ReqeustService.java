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

  public String postResponse(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return bodyRequest(path, params, "POST", header);
  }

  public String putResponse(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return bodyRequest(path, params, "PUT", header);
  }

  public String patchResponse(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return bodyRequest(path, params, "PATCH", header);
  }
}
