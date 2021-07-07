package proj.gateway.apigateway.common.service;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.Map;
import org.springframework.stereotype.Service;
import proj.gateway.apigateway.common.utils.HttpUtils;
import proj.gateway.apigateway.common.commonEnum.Endpoint;
import proj.gateway.apigateway.common.utils.ConvertUtils;

/**
 * 공통 서비스 객체
 */
@Service
public class CommonService {

  /**
   * API별 맞는 도메인을 전달
   * 
   * @param path
   * @return
   */
  private static String generateDomain(String path) {

    Map<String, String> apiServerEndpoints = Endpoint.getApiServerEndpoints();
    if (apiServerEndpoints.containsValue(path) == true) {
      return "http://localhost:3001/";
    }

    Map<String, String> designServerEndpoints = Endpoint.getDesignServerEndpoints();
    if (designServerEndpoints.containsValue(path) == true) {
      return "http://localhost:3002/";
    }

    return "";
  }

  /**
   * query를 던지는 HTTP Method를 위한 Reqeust
   * 
   * @param path
   * @param method
   * @return JSON.stringify
   * @throws Exception
   */
  public static String queryRequest(String path, Map<String, String> params, String method,
      Map<String, String> header) throws Exception {
    String domain = generateDomain(path);
    String url = domain + path + (params.size() > 0 ? ConvertUtils.queryToString(params) : "");
    HttpURLConnection request = HttpUtils.request(url, method);
    String reponse = HttpUtils.response(request);
    return reponse;
  }

  /**
   * Body를 던지는 HTTP Method를 위한 Reqeust
   * 
   * @param path
   * @param method
   * @return JSON.stringify
   * @throws Exception
   */
  public static String bodyRequest(String path, Map<String, String> params, String method,
      Map<String, String> header) throws Exception {
    String domain = generateDomain(path);
    String url = domain + path;

    // Spring Gateway server -> Node Server (Contents Type: JSON)
    // Json string로 변환시킨 후, Node 서버에서 파싱
    String jsonParams = ConvertUtils.objectToJsonString(params);

    HttpURLConnection request = HttpUtils.request(url, method);

    DataOutputStream dataOutputStream = new DataOutputStream(request.getOutputStream());
    dataOutputStream.writeBytes(jsonParams);
    dataOutputStream.flush();
    dataOutputStream.close();

    String reponse = HttpUtils.response(request);
    return reponse;
  }
}
