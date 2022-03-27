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
public class CommonModelService {

  private final HttpModule httpModule;

  @CircuitBreaker(name = "clientHealth", fallbackMethod = "clientHealthFallBack")
  public Map<String, Object> clientHealth(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "designHealth", fallbackMethod = "designHealthFallBack")
  public Map<String, Object> designHealth(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  @CircuitBreaker(name = "findDashboardCount", fallbackMethod = "findDashboardCountFallBack")
  public Map<String, Object> findDashboardCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(queryString, path, token);
  }

  public Map<String, Object> clientHealthFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== clientHealthFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> designHealthFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== designHealthFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> findDashboardCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findDashboardCountFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }
}
