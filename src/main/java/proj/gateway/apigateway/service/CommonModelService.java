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
public class CommonModelService {

  private final HttpModule httpModule;

  @Value("${domain.apiServer}")
  private String apiServerDomain;

  @Value("${domain.designServer}")
  private String designServerDomain;

  @CircuitBreaker(name = "getClientHealth", fallbackMethod = "getClientHealthFallBack")
  public Map<String, Object> getClientHealth(HttpServletRequest request) throws APIResponseException {
    String url = apiServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getDesignHealth", fallbackMethod = "getDesignHealthFallBack")
  public Map<String, Object> getDesignHealth(HttpServletRequest request) throws APIResponseException {
    String url = designServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  @CircuitBreaker(name = "getDashboardCount", fallbackMethod = "getDashboardCountFallBack")
  public Map<String, Object> getDashboardCount(HttpServletRequest request) throws APIResponseException {
    String url = apiServerDomain + request.getRequestURI();
    String token = request.getHeader("authorization");

    return httpModule.getRequest(url, token);
  }

  public Map<String, Object> getClientHealthFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getClientHealthFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getDesignHealthFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getDesignHealthFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }

  public Map<String, Object> getDashboardCountFallBack(HttpServletRequest request, Throwable throwable)
      throws FallBackException {
    System.out.println("============== getDashboardCountFallBack ==============");
    throw new FallBackException(throwable.getMessage());
  }
}
