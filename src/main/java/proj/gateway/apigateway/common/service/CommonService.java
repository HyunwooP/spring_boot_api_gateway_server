package proj.gateway.apigateway.common.service;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import proj.gateway.apigateway.common.commonEnum.Endpoint;
import proj.gateway.apigateway.common.utils.ConvertUtils;
import proj.gateway.apigateway.common.utils.HttpUtils;

@Service
public class CommonService {
  // RestController에 넘길 reponse 객체
  private HashMap<String, Object> response = new HashMap<String, Object>();
  // Logger
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private String generateDomain(String path) {
    Map<String, String> apiServerEndpoints = Endpoint.getApiServerEndpoints();
    if (apiServerEndpoints.containsValue(path)) {
      return "http://localhost:3001";
    }

    Map<String, String> designServerEndpoints = Endpoint.getDesignServerEndpoints();
    if (designServerEndpoints.containsValue(path)) {
      return "http://localhost:3002";
    }

    throw new Error("That API doesn't exist.");
  }

  public HashMap<String, Object> queryRequest(String queryString, String path, String method, String token)
      throws Exception {
    String domain = generateDomain(path);
    String url = domain + path + (queryString != null ? "?" + queryString : "");

    HttpURLConnection request = HttpUtils.request(url, method, token);

    response.put("status", request.getResponseCode());
    response.put("data", HttpUtils.response(request));

    logger.info(method + " Request - " + url);
    return response;
  }

  public HashMap<String, Object> bodyRequest(String path, String method, String token,
      Map<String, Object> body) throws Exception {
    String domain = generateDomain(path);
    String url = domain + path;

    // Spring Gateway server -> Node Server (Contents Type: JSON)
    // Json string로 변환시킨 후, Node 서버에서 파싱
    String jsonParams = ConvertUtils.objectToJsonString(body);

    HttpURLConnection request = HttpUtils.request(url, method, token);

    DataOutputStream dataOutputStream = new DataOutputStream(request.getOutputStream());
    dataOutputStream.write(jsonParams.getBytes("UTF-8"));
    dataOutputStream.flush();
    dataOutputStream.close();

    response.put("status", request.getResponseCode());
    response.put("data", HttpUtils.response(request));

    logger.info(method + " Request - " + url);
    return response;
  }
}
