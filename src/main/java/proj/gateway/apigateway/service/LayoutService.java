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
public class LayoutService {

  private final HttpModule httpModule;

  @Value("${domain.designServer}")
  private String designServerDomain;

  @CircuitBreaker(name = "getLayoutCount", fallbackMethod = "getLayoutCountFallBack")
  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String url = designServerDomain + request.getRequestURI() + (queryString != null ? "?" + queryString : "");
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getLayout", fallbackMethod = "getLayoutFallBack")
  public Map<String, Object> getLayout(HttpServletRequest request) throws APIResponseException {
    String url = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getLayouts", fallbackMethod = "getLayoutsFallBack")
  public Map<String, Object> getLayouts(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String url = designServerDomain + request.getRequestURI() + (queryString != null ? "?" + queryString : "");
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "removeLayout", fallbackMethod = "removeLayoutFallBack")
  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException {
    String url = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.deleteRequest(url, token);
  }

  public Map<String, Object> getLayoutCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getLayoutCountFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getLayoutFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getLayoutFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getLayoutsFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getLayoutsFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeLayoutFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeLayoutFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }
}
