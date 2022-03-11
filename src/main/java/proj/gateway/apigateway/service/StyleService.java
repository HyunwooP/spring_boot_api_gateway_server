package proj.gateway.apigateway.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import proj.gateway.apigateway.common.error.APIResponseException;
import proj.gateway.apigateway.common.error.FallbackException;
import proj.gateway.apigateway.common.service.CommonService;

@Service("StyleService")
public class StyleService extends CommonService {

  @CircuitBreaker(name = "findStyleCount", fallbackMethod = "findStyleCountFallBack")
  public HashMap<String, Object> findStyleCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "findStyle", fallbackMethod = "findStyleFallBack")
  public HashMap<String, Object> findStyle(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "removeStyle", fallbackMethod = "removeStyleFallBack")
  public HashMap<String, Object> removeStyle(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> findStyleCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }

  public HashMap<String, Object> findStyleFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }

  public HashMap<String, Object> removeStyleFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }
}
