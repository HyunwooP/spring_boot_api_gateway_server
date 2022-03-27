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
public class ContentsService {

  private final HttpModule httpModule;

  @CircuitBreaker(name = "findContentsCount", fallbackMethod = "findContentsCountFallBack")
  public Map<String, Object> findContentsCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "findContents", fallbackMethod = "findContentsFallBack")
  public Map<String, Object> findContents(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "createContents", fallbackMethod = "createContentsFallBack")
  public Map<String, Object> createContents(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.postRequest(path, token, body);
  }

  @CircuitBreaker(name = "updateContents", fallbackMethod = "updateContentsFallBack")
  public Map<String, Object> updateContents(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException {
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.patchRequest(path, token, body);
  }

  @CircuitBreaker(name = "removeContents", fallbackMethod = "removeContentsFallBack")
  public Map<String, Object> removeContents(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.deleteRequest(queryString, path, token);
  }

  public Map<String, Object> findContentsCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findContentsCountFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> findContentsFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findContentsFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> createContentsFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== createContentsFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> updateContentsFallBack(HttpServletRequest request, Map<String, Object> body,
      Throwable throwable)
      throws FallBackException {
    System.out.println("============== updateContentsFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> removeContentsFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== removeContentsFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }
}
