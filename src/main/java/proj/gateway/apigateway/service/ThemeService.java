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
public class ThemeService {

  private final HttpModule httpModule;

  @Value("${domain.designServer}")
  private String designServerDomain;

  @CircuitBreaker(name = "getThemeCount", fallbackMethod = "getThemeCountFallBack")
  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String url = designServerDomain + request.getRequestURI() + (queryString != null ? "?" + queryString : "");
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getThemeItem", fallbackMethod = "getThemeItemFallBack")
  public Map<String, Object> getThemeItem(HttpServletRequest request) throws APIResponseException {
    String url = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getTheme", fallbackMethod = "getThemeFallBack")
  public Map<String, Object> getTheme(HttpServletRequest request) throws APIResponseException {
    String url = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getThemes", fallbackMethod = "getThemesFallBack")
  public Map<String, Object> getThemes(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String url = designServerDomain + request.getRequestURI() + (queryString != null ? "?" + queryString : "");
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "removeTheme", fallbackMethod = "removeThemeFallBack")
  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException {
    String url = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.deleteRequest(url, token);
  }

  public Map<String, Object> getThemeCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getThemeCountFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getThemeItemFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getThemeItemFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getThemeFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getThemeFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getThemesFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getThemesFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeThemeFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeThemeFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }
}
