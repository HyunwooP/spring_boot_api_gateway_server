package proj.gateway.apigateway.service;

import java.util.Map;
import org.springframework.stereotype.Service;
import proj.gateway.apigateway.common.service.CommonService;

@Service
public class ReqeustService extends CommonService {

  public String getReponse(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return queryRequest(path, params, "GET", header);
  }

  public String deleteReponse(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return queryRequest(path, params, "DELETE", header);
  }

  public String postReponse(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return bodyRequest(path, params, "POST", header);
  }

  public String putReponse(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return bodyRequest(path, params, "PUT", header);
  }

  public String patchReponse(String path, Map<String, String> params, Map<String, String> header)
      throws Exception {
    return bodyRequest(path, params, "PATCH", header);
  }
}
