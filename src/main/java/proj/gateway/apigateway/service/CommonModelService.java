package proj.gateway.apigateway.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.common.error.exceptions.FallBackException;
import proj.gateway.apigateway.common.service.CommonService;

@Service("CommonModelService")
public class CommonModelService extends CommonService {

  @CircuitBreaker(name = "clientHealth", fallbackMethod = "clientHealthFallBack")
  public HashMap<String, Object> clientHealth(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "designHealth", fallbackMethod = "designHealthFallBack")
  public HashMap<String, Object> designHealth(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  @CircuitBreaker(name = "findDashboardCount", fallbackMethod = "findDashboardCountFallBack")
  public HashMap<String, Object> findDashboardCount(HttpServletRequest request) throws APIResponseException {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> clientHealthFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== clientHealthFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public HashMap<String, Object> designHealthFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== designHealthFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public HashMap<String, Object> findDashboardCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== findDashboardCountFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }
}
