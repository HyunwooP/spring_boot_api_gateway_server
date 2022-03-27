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
public class ComponentService {

  private final HttpModule httpModule;

  @CircuitBreaker(name = "findComponentCount", fallbackMethod = "findComponentCountFallBack")
  public Map<String, Object> findComponentCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "findComponent", fallbackMethod = "findComponentFallBack")
  public Map<String, Object> findComponent(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "removeComponent", fallbackMethod = "removeComponentFallBack")
  public Map<String, Object> removeComponent(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  public Map<String, Object> findComponentCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findComponentCountFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> findComponentFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findComponentFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeComponentFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeComponentFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }
}
