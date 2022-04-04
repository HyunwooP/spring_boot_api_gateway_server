package proj.gateway.apigateway.common.component.utils;

import java.util.Map;

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

  public Map<String, Object> request(HttpMethod method, String url, String token, MultiValueMap<String, String> body) {
    final HttpHeaders headers = new HttpHeaders();
    headers.set("authorization", token);
    final HttpEntity<Object> entity = new HttpEntity<>(body, headers);
    final ResponseEntity<Map<String, Object>> exchangeResponse = restTemplate.exchange(
        url,
        method,
        entity,
        new ParameterizedTypeReference<Map<String, Object>>() {
        });

    return exchangeResponse.getBody();
  }

  public MultiValueMap<String, String> generateBody(Map<String, Object> body) {
    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
    for (String key : body.keySet()) {
      parameters.add(key, body.get(key).toString());
    }

    return parameters;
  }

  public String generateQueryString(String domain, String endPoint, String queryString) {
    return domain + endPoint + (queryString != null ? "?" + queryString : "");
  }
}