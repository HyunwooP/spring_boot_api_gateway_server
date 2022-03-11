package proj.gateway.apigateway.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import proj.gateway.apigateway.common.error.APIResponseException;
import proj.gateway.apigateway.common.error.FallbackException;
import proj.gateway.apigateway.common.service.CommonService;

@Service("ContentsService")
public class ContentsService extends CommonService {

  @CircuitBreaker(name = "findContentsCount", fallbackMethod = "findContentsCountFallBack")
  public HashMap<String, Object> findContentsCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "findContents", fallbackMethod = "findContentsFallBack")
  public HashMap<String, Object> findContents(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "createContents", fallbackMethod = "createContentsFallBack")
  public HashMap<String, Object> createContents(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return bodyRequest(path, method, token, body);
  }

  @CircuitBreaker(name = "updateContents", fallbackMethod = "updateContentsFallBack")
  public HashMap<String, Object> updateContents(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return bodyRequest(path, method, token, body);
  }

  @CircuitBreaker(name = "removeContents", fallbackMethod = "removeContentsFallBack")
  public HashMap<String, Object> removeContents(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> findContentsCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }

  public HashMap<String, Object> findContentsFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }

  public HashMap<String, Object> createContentsFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }

  public HashMap<String, Object> updateContentsFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }

  public HashMap<String, Object> removeContentsFallBack(HttpServletRequest request, Throwable throwable)
      throws FallbackException {
    throw new FallbackException(request.getRequestURI());
  }
}
