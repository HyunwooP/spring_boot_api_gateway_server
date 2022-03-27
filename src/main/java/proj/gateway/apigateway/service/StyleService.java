package proj.gateway.apigateway.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.component.HttpModule;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.common.error.exceptions.FallBackException;

@Service
@RequiredArgsConstructor
public class StyleService {

  private final HttpModule httpModule;

  @CircuitBreaker(name = "findStyleCount", fallbackMethod = "findStyleCountFallBack")
  public Map<String, Object> findStyleCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "findStyle", fallbackMethod = "findStyleFallBack")
  public Map<String, Object> findStyle(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "removeStyle", fallbackMethod = "removeStyleFallBack")
  public Map<String, Object> removeStyle(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.deleteRequest(queryString, path, token);
  }

  public Map<String, Object> findStyleCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findStyleCountFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> findStyleFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findStyleFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeStyleFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeStyleFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }
}
