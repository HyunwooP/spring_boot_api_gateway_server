package proj.gateway.apigateway.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
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

  @Value("${domain.designServer}")
  private String designServerDomain;

  @CircuitBreaker(name = "getComponentCount", fallbackMethod = "getComponentCountFallBack")
  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String url = designServerDomain + request.getRequestURI() + (queryString != null ? "?" + queryString : "");
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getComponent", fallbackMethod = "getComponentFallBack")
  public Map<String, Object> getComponent(HttpServletRequest request) throws APIResponseException {
    String url = designServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getComponents", fallbackMethod = "getComponentsFallBack")
  public Map<String, Object> getComponents(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String url = designServerDomain + request.getRequestURI() + (queryString != null ? "?" + queryString : "");
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "removeComponent", fallbackMethod = "removeComponentFallBack")
  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException {
    String url = designServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.deleteRequest(url, token);
  }

  public Map<String, Object> getComponentCountFallback(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getComponentCountFallback ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getComponentFallback(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getComponentFallback ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getComponentsFallback(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getComponentsFallback ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeComponentFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeComponentFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }
}
