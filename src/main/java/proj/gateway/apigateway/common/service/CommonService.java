package proj.gateway.apigateway.common.service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import proj.gateway.apigateway.common.commonEnum.Endpoint;
import proj.gateway.apigateway.common.error.APIResponseException;
import proj.gateway.apigateway.common.error.NotFoundAPIException;
import proj.gateway.apigateway.common.utils.ConvertUtils;
import proj.gateway.apigateway.common.utils.HttpUtils;

@Service
public class CommonService {
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

    throw new NotFoundAPIException();
  }

  public HashMap<String, Object> queryRequest(String queryString, String path, String method, String token)
      throws APIResponseException {

    HashMap<String, Object> response = new HashMap<String, Object>();

    try {
      String domain = generateDomain(path);
      String url = domain + path + (queryString != null ? "?" + queryString : "");

      HttpURLConnection request = HttpUtils.generateRequest(url, method, token);
      response.put("status", request.getResponseCode());
      response.put("data", HttpUtils.generateResponse(request));

      logger.info(method + " Request - " + url);
      return response;
    } catch (Exception exception) {
      String _status = "500";

      if (exception instanceof IOException) {
        Object status = response.get("status");
        _status = status == null ? "502" : status.toString();
      } else if (exception instanceof NotFoundAPIException) {
        _status = "404";
      }

      throw new APIResponseException(_status);
    }
  }

  public HashMap<String, Object> bodyRequest(String path, String method, String token,
      Map<String, Object> body) throws APIResponseException {

    HashMap<String, Object> response = new HashMap<String, Object>();

    try {
      String domain = generateDomain(path);
      String url = domain + path;

      // Spring Gateway server -> Node Server (Contents Type: JSON)
      // Json string로 변환시킨 후, Node 서버에서 파싱
      String jsonParams = ConvertUtils.objectToJsonString(body);
      HttpURLConnection request = HttpUtils.generateRequest(url, method, token);

      DataOutputStream dataOutputStream = new DataOutputStream(request.getOutputStream());
      dataOutputStream.write(jsonParams.getBytes("UTF-8"));
      dataOutputStream.flush();
      dataOutputStream.close();

      response.put("status", request.getResponseCode());
      response.put("data", HttpUtils.generateResponse(request));

      logger.info(method + " Request - " + url);
      return response;
    } catch (Exception exception) {
      String _status = "500";

      if (exception instanceof IOException) {
        Object status = response.get("status");
        _status = status == null ? "502" : status.toString();
      } else if (exception instanceof NotFoundAPIException) {
        _status = "404";
      }

      throw new APIResponseException(_status);
    }
  }
}
