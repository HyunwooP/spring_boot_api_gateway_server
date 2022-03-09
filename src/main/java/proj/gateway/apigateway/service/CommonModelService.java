package proj.gateway.apigateway.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import proj.gateway.apigateway.common.service.CommonService;

@Service("CommonModelService")
public class CommonModelService extends CommonService {

  public HashMap<String, Object> health(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> findDashboardCount(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }
}
