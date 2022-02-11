package proj.gateway.apigateway.common.service;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import proj.gateway.apigateway.common.commonEnum.Endpoint;
import proj.gateway.apigateway.common.utils.ConvertUtils;
import proj.gateway.apigateway.common.utils.HttpUtils;

/**
 * 공통 서비스 객체
 */
@Service
public class CommonService {
  // API 엔드포인트
  private String path;
  // API Method
  private String method;
  // API 토큰
  private String token;
  // Node 서버 도메인
  private String domain;
  // RestController에 넘길 reponse 객체
  private HashMap<String, Object> response = new HashMap<String, Object>();
  // Logger
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * API별 맞는 도메인을 전달
   * 
   * @param path
   * @return
   */
  private void generateDomain() {

    Map<String, String> apiServerEndpoints = Endpoint.getApiServerEndpoints();
    if (apiServerEndpoints.containsValue(path) == true) {
      domain = "http://localhost:3001";
    }

    Map<String, String> designServerEndpoints = Endpoint.getDesignServerEndpoints();
    if (designServerEndpoints.containsValue(path) == true) {
      domain = "http://localhost:3002";
    }
  }

  /**
   * query를 던지는 HTTP Method를 위한 Request
   * 
   * @param req
   * @return HashMap<String, Object> response
   * @throws Exception
   */
  public HashMap<String, Object> queryRequest(HttpServletRequest req) throws Exception {
    String queryString = req.getQueryString();
    path = req.getRequestURI();
    method = req.getMethod();
    token = req.getHeader("authorization");

    generateDomain();

    String url = domain + path + (queryString != null ? "?" + queryString : "");
    HttpURLConnection request = HttpUtils.request(url, method, token);

    response.put("status", request.getResponseCode());
    response.put("data", HttpUtils.response(request));

    logger.info(method + " Request - " + url);
    return response;
  }

  /**
   * Body를 던지는 HTTP Method를 위한 Request
   * 
   * @param path
   * @param method
   * @return JSON.stringify
   * @throws Exception
   */
  public HashMap<String, Object> bodyRequest(HttpServletRequest req, Map<String, Object> body) throws Exception {
    path = req.getRequestURI();
    method = req.getMethod();
    token = req.getHeader("authorization");

    generateDomain();

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
