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
public class StyleService {

  private final HttpModule httpModule;

  @Value("${domain.designServer}")
  private String designServerDomain;

  @CircuitBreaker(name = "getStyleCount", fallbackMethod = "getStyleCountFallBack")
  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String url = designServerDomain + request.getRequestURI() + (queryString != null ? "?" + queryString : "");
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getStyle", fallbackMethod = "getStyleFallBack")
  public Map<String, Object> getStyle(HttpServletRequest request) throws APIResponseException {
    String url = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getStyles", fallbackMethod = "getStylesFallBack")
  public Map<String, Object> getStyles(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String url = designServerDomain + request.getRequestURI() + (queryString != null ? "?" + queryString : "");
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "removeStyle", fallbackMethod = "removeStyleFallBack")
  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException {
    String url = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.deleteRequest(url, token);
  }

  public Map<String, Object> getStyleCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getStyleCountFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getStyleFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getStyleFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getStylesFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getStylesFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeStyleFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeStyleFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }
}
