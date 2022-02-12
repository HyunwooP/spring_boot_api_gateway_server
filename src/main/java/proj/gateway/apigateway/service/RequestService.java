package proj.gateway.apigateway.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import proj.gateway.apigateway.common.service.CommonService;

@Service("requestService")
public class RequestService extends CommonService {

  @CircuitBreaker(name = "get", fallbackMethod = "queryRequestFallBack")
  public HashMap<String, Object> get(HttpServletRequest req) throws Exception {
    return queryRequest(req);
  }

  @CircuitBreaker(name = "delete", fallbackMethod = "queryRequestFallBack")
  public HashMap<String, Object> delete(HttpServletRequest req) throws Exception {
    return queryRequest(req);
  }

  @CircuitBreaker(name = "post", fallbackMethod = "bodyRequestFallBack")
  public HashMap<String, Object> post(HttpServletRequest req, Map<String, Object> body) throws Exception {
    return bodyRequest(req, body);
  }

  @CircuitBreaker(name = "put", fallbackMethod = "bodyRequestFallBack")
  public HashMap<String, Object> put(HttpServletRequest req, Map<String, Object> body) throws Exception {
    return bodyRequest(req, body);
  }

  @CircuitBreaker(name = "patch", fallbackMethod = "bodyRequestFallBack")
  public HashMap<String, Object> patch(HttpServletRequest req, Map<String, Object> body) throws Exception {
    return bodyRequest(req, body);
  }

  public HashMap<String, Object> queryRequestFallBack(HttpServletRequest req, Throwable t) throws Exception {
    throw new Exception(t.getMessage());
  }

  public HashMap<String, Object> bodyRequestFallBack(HttpServletRequest req, Map<String, Object> body, Throwable t)
      throws Exception {
    throw new Exception(t.getMessage());
  }
}
