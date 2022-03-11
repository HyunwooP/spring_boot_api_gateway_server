package proj.gateway.apigateway.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import proj.gateway.apigateway.common.error.APIResponseException;
import proj.gateway.apigateway.common.error.FallbackException;
import proj.gateway.apigateway.common.service.CommonService;

@Service("ComponentService")
public class ComponentService extends CommonService {

  @CircuitBreaker(name = "findComponentCount", fallbackMethod = "findComponentCountFallBack")
  public HashMap<String, Object> findComponentCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "findComponent", fallbackMethod = "findComponentFallBack")
  public HashMap<String, Object> findComponent(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "removeComponent", fallbackMethod = "removeComponentFallBack")
  public HashMap<String, Object> removeComponent(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> findComponentCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }

  public HashMap<String, Object> findComponentFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }

  public HashMap<String, Object> removeComponentFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }
}
