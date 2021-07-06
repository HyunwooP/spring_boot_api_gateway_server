package proj.gateway.apigateway.service;

import java.util.Map;
import org.springframework.stereotype.Service;
import proj.gateway.apigateway.common.service.CommonService;

/**
 * Delete 서비스
 */
@Service
public class DeleteService extends CommonService {

  public String response(String path, Map<String, String> params) throws Exception {
    return queryRequest(path, params, "DELETE");
  }
}
