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
public class ContentsService {

  private final HttpModule httpModule;

  @Value("${domain.apiServer}")
  private String apiServerDomain;

  @CircuitBreaker(name = "getContentsCount", fallbackMethod = "getContentsCountFallBack")
  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String url = apiServerDomain + request.getRequestURI() + (queryString != null ? "?" + queryString : "");
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getContent", fallbackMethod = "getContentFallBack")
  public Map<String, Object> getContent(HttpServletRequest request) throws APIResponseException {
    String url = apiServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getContents", fallbackMethod = "getContentsFallBack")
  public Map<String, Object> getContents(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String url = apiServerDomain + request.getRequestURI() + (queryString != null ? "?" + queryString : "");
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "createContent", fallbackMethod = "createContentFallBack")
  public Map<String, Object> create(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    String url = apiServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.postRequest(url, token, body);
  }

  @CircuitBreaker(name = "updateContent", fallbackMethod = "updateContentsFallBack")
  public Map<String, Object> update(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    String url = apiServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.patchRequest(url, token, body);
  }

  @CircuitBreaker(name = "removeContent", fallbackMethod = "removeContentFallBack")
  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException {
    String url = apiServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.deleteRequest(url, token);
  }

  public Map<String, Object> getContentsCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getContentsCountFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getContentFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getContentFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getContentsFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getContentsFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> createContentsFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== createContentsFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> updateContentsFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== updateContentsFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeContentFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeContentFallBack ==============" + throwable.getMessage());
    throw new FallBackException(throwable.getMessage());
  }
}
