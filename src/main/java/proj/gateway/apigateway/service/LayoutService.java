package proj.gateway.apigateway.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import proj.gateway.apigateway.common.service.CommonService;

@Service("LayoutService")
public class LayoutService extends CommonService {

  @CircuitBreaker(name = "findLayoutCount", fallbackMethod = "findLayoutCountFallBack")
  public HashMap<String, Object> findLayoutCount(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "findLayout", fallbackMethod = "findLayoutFallBack")
  public HashMap<String, Object> findLayout(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "removeLayout", fallbackMethod = "removeLayoutFallBack")
  public HashMap<String, Object> removeLayout(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> findLayoutCountFallBack(HttpServletRequest request, Throwable throwable)
      throws Exception {
    throw new Exception(throwable.getMessage());
  }

  public HashMap<String, Object> findLayoutFallBack(HttpServletRequest request, Throwable throwable)
      throws Exception {
    throw new Exception(throwable.getMessage());
  }

  public HashMap<String, Object> removeLayoutFallBack(HttpServletRequest request, Throwable throwable)
      throws Exception {
    throw new Exception(throwable.getMessage());
  }
}
