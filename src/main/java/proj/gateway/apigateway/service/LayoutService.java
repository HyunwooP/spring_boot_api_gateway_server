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
public class LayoutService {

  private final HttpModule httpModule;

  @CircuitBreaker(name = "findLayoutCount", fallbackMethod = "findLayoutCountFallBack")
  public Map<String, Object> findLayoutCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "findLayout", fallbackMethod = "findLayoutFallBack")
  public Map<String, Object> findLayout(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "removeLayout", fallbackMethod = "removeLayoutFallBack")
  public Map<String, Object> removeLayout(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.deleteRequest(queryString, path, token);
  }

  public Map<String, Object> findLayoutCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findLayoutCountFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> findLayoutFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findLayoutFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeLayoutFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeLayoutFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }
}
