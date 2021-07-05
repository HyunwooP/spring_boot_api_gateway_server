package proj.gateway.apigateway.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class GetService {

  public String response(String path, Map<String, String> params) throws Exception {
    // todo
    // 1. API서버, 디자인서버 도메인 따로 정의 하고, path별 어디 서버에 바라보아야 할 지 로직 작성하기.
    // 2. HTTP 공통 객체 만들기

    URL endpoint = new URL("http://localhost:3001/" + path);
    HttpURLConnection connection = (HttpURLConnection) endpoint.openConnection();

    connection.setRequestMethod("GET");
    connection.setDoOutput(true);

    int responseCode = connection.getResponseCode();

    BufferedReader bufferedReader =
        new BufferedReader(new InputStreamReader(connection.getInputStream()));
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
