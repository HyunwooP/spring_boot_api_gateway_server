package proj.gateway.apigateway.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import proj.gateway.apigateway.common.service.CommonService;

@Service("requestService")
public class RequestService extends CommonService {

  @CircuitBreaker(name = "get", fallbackMethod = "queryFallBack")
  public HashMap<String, Object> get(HttpServletRequest req) throws Exception {
    return queryRequest(req);
  }

  @CircuitBreaker(name = "delete", fallbackMethod = "queryFallBack")
  public HashMap<String, Object> delete(HttpServletRequest req) throws Exception {
    return queryRequest(req);
  }

  @CircuitBreaker(name = "post", fallbackMethod = "bodyFallBack")
  public HashMap<String, Object> post(HttpServletRequest req, Map<String, Object> body) throws Exception {
    return bodyRequest(req, body);
  }

  @CircuitBreaker(name = "put", fallbackMethod = "bodyFallBack")
  public HashMap<String, Object> put(HttpServletRequest req, Map<String, Object> body) throws Exception {
    return bodyRequest(req, body);
  }

  @CircuitBreaker(name = "patch", fallbackMethod = "bodyFallBack")
  public HashMap<String, Object> patch(HttpServletRequest req, Map<String, Object> body) throws Exception {
    return bodyRequest(req, body);
  }

  public HashMap<String, Object> queryFallBack(HttpServletRequest req, Throwable t) throws Exception {
    System.out.println("=========== queryFallBack Call!!! ===========");
    throw new Exception(t.getMessage());
  }

  public HashMap<String, Object> bodyFallBack(HttpServletRequest req, Map<String, Object> body,
      CallNotPermittedException t) throws Exception {
    System.out.println("=========== bodyFallBack Call!!! ===========");
    throw new Exception(t.getMessage());
  }
}
