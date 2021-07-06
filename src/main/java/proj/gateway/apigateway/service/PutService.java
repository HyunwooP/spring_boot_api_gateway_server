package proj.gateway.apigateway.service;

import java.util.Map;
import org.springframework.stereotype.Service;
import proj.gateway.apigateway.common.service.CommonService;

/**
 * Put 서비스
 */
@Service
public class PutService extends CommonService {

  public String response(String path, Map<String, String> params) throws Exception {
    return bodyRequest(path, params, "PUT");
  }
}
