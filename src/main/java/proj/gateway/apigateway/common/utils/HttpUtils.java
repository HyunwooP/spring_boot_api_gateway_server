package proj.gateway.apigateway.common.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

/**
 * HTTP 통신을 위한 Utils
 */
@Component
public class HttpUtils {

  /**
   * request 객체
   * 
   * @param url
   * @param method
   * @return
   * @throws Exception
   */
  public static HttpURLConnection request(String url, String method, String token) throws Exception {
    URL endpoint = new URL(url);
    HttpURLConnection connection = (HttpURLConnection) endpoint.openConnection();

    // https://stackoverflow.com/questions/25163131/httpurlconnection-invalid-http-method-patch
    if (method.equals("PATCH") || method.equals("PUT")) {
      connection.setRequestProperty("X-HTTP-Method-Override", method);
      method = "POST";
    }

    connection.setRequestMethod(method);
    connection.setDoInput(true);
    connection.setDoOutput(true);
    connection.setRequestProperty("Cache-Control", "no-cache");
    connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
    connection.setRequestProperty("authorization", token);
    return connection;
  }

  /**
   * response 객체
   * 
   * @param request
   * @return
   * @throws Exception
   */
  public static String response(HttpURLConnection request) throws Exception {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
    StringBuffer stringBuffer = new StringBuffer();
    String inputLine;

    while ((inputLine = bufferedReader.readLine()) != null) {
      stringBuffer.append(inputLine);
    }
    bufferedReader.close();

    String _response = stringBuffer.toString();
    return _response;
  }

}
