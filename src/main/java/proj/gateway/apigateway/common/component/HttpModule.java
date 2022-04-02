package proj.gateway.apigateway.common.component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.component.utils.HttpUtils;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.common.error.exceptions.NotFoundAPIException;

@Component
@RequiredArgsConstructor
public class HttpModule {
  private final HttpUtils httpUtils;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Value("${domain.apiServer}")
  private String apiServerDomain;

  @Value("${domain.designServer}")
  private String designServerDomain;

  private Map<String, Object> queryRequest(String url, String token, HttpMethod method)
      throws APIResponseException {
    Map<String, Object> response = new HashMap<String, Object>();

    try {
      response = httpUtils.request(method, url, token, null);

      logger.info("queryRequest - " + url);
      return response;
    } catch (Exception exception) {
      String _status = "500";

      if (exception instanceof IOException) {
        Object status = response.get("status");
        _status = status == null ? "502" : status.toString();
      } else if (exception instanceof NotFoundAPIException) {
        _status = "404";
      } else if (exception instanceof HttpClientErrorException) {
        Object status = exception.getMessage().split(" ")[0];
        _status = status == null ? "400" : status.toString();
      }

      throw new APIResponseException(_status);
    }
  }

  private Map<String, Object> bodyRequest(String url, String token, Map<String, Object> body, HttpMethod method)
      throws APIResponseException {
    Map<String, Object> response = new HashMap<String, Object>();

    try {
      MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();

      for (String key : body.keySet()) {
        parameters.add(key, body.get(key).toString());
      }

      response = httpUtils.request(method, url, token, parameters);

      logger.info("bodyRequest - " + url);
      return response;
    } catch (Exception exception) {
      String _status = "500";

      if (exception instanceof IOException) {
        Object status = response.get("status");
        _status = status == null ? "502" : status.toString();
      } else if (exception instanceof NotFoundAPIException) {
        _status = "404";
      } else if (exception instanceof HttpClientErrorException) {
        Object status = exception.getMessage().split(" ")[0];
        _status = status == null ? "400" : status.toString();
      }

      throw new APIResponseException(_status);
    }
  }

  public Map<String, Object> getRequest(String url, String token) throws APIResponseException {
    return queryRequest(url, token, HttpMethod.GET);
  }

  public Map<String, Object> deleteRequest(String url, String token) throws APIResponseException {
    return queryRequest(url, token, HttpMethod.DELETE);
  }

  public Map<String, Object> postRequest(String url, String token, Map<String, Object> body)
      throws APIResponseException {
    return bodyRequest(url, token, body, HttpMethod.POST);
  }

  public Map<String, Object> patchRequest(String url, String token, Map<String, Object> body)
      throws APIResponseException {
    return bodyRequest(url, token, body, HttpMethod.PATCH);
  }

  public Map<String, Object> putRequest(String url, String token, Map<String, Object> body)
      throws APIResponseException {
    return bodyRequest(url, token, body, HttpMethod.PUT);
  }
}
