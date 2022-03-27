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
public class ThemeService {

  private final HttpModule httpModule;

  @CircuitBreaker(name = "findThemeCount", fallbackMethod = "findThemeCountFallBack")
  public Map<String, Object> findThemeCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "findThemeItem", fallbackMethod = "findThemeItemFallBack")
  public Map<String, Object> findThemeItem(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "findTheme", fallbackMethod = "findThemeFallBack")
  public Map<String, Object> findTheme(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "removeTheme", fallbackMethod = "removeThemeFallBack")
  public Map<String, Object> removeTheme(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.deleteRequest(queryString, path, token);
  }

  public Map<String, Object> findThemeCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findThemeCountFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> findThemeItemFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findThemeItemFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> findThemeFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findThemeFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeThemeFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeThemeFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }
}
