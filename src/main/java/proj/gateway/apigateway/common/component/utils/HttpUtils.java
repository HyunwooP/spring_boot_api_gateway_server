package proj.gateway.apigateway.common.component.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HttpUtils {

  private final RestTemplate restTemplate;

  private static Map<String, Object> generateResponseModal(ResponseEntity<Map<String, Object>> exchangeResponse) {
    HashMap<String, Object> response = new HashMap<String, Object>();

    response.put("status", exchangeResponse.getStatusCode().value());
    response.put("data", exchangeResponse.getBody());

    return response;
  };

  private Map<String, Object> request(HttpMethod method, String url, String token, MultiValueMap<String, String> body) {
    final HttpHeaders headers = new HttpHeaders();
    headers.set("authorization", token);
    final HttpEntity<Object> entity = new HttpEntity<>(body, headers);
    final ResponseEntity<Map<String, Object>> exchangeResponse = restTemplate.exchange(
        url,
        method,
        entity,
        new ParameterizedTypeReference<Map<String, Object>>() {
        });

    return generateResponseModal(exchangeResponse);
  }

  public Map<String, Object> queryRequest(HttpMethod method, String url, String token) {
    return request(method, url, token, null);
  }

  public Map<String, Object> bodyRequest(HttpMethod method, String url, String token, Map<String, Object> body) {
    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();

    for (String key : body.keySet()) {
      parameters.add(key, body.get(key).toString());
    }

    return request(method, url, token, parameters);
  }

  public Map<String, Object> get(String url, String token) {
    return queryRequest(HttpMethod.GET, url, token);
  }

  public Map<String, Object> delete(String url, String token) {
    return queryRequest(HttpMethod.DELETE, url, token);
  }

  public Map<String, Object> post(String url, String token, Map<String, Object> body) {
    return bodyRequest(HttpMethod.POST, url, token, body);
  }

  public Map<String, Object> patch(String url, String token, Map<String, Object> body) {
    return bodyRequest(HttpMethod.PATCH, url, token, body);
  }

  public Map<String, Object> put(String url, String token, Map<String, Object> body) {
    return bodyRequest(HttpMethod.PUT, url, token, body);
  }

  public static Map<String, Object> send(Map<String, Object> apiResponse, HttpServletResponse response) {
    int status = (int) apiResponse.get("status");
    Map<String, Object> responseJson = (Map<String, Object>) apiResponse.get("data");

    response.setStatus(status);
    return responseJson;
  }
}