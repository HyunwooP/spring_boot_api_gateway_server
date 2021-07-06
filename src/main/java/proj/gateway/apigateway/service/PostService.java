package proj.gateway.apigateway.service;

import java.util.Map;
import org.springframework.stereotype.Service;
import proj.gateway.apigateway.common.service.CommonService;

/**
 * Post 서비스
 */
@Service
public class PostService extends CommonService {

  public String response(String path, Map<String, String> params) throws Exception {
    return bodyRequest(path, params, "POST");
  }
}
