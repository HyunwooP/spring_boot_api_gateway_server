package proj.gateway.apigateway.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import proj.gateway.apigateway.common.service.CommonService;

@Service("ComponentService")
public class ComponentService extends CommonService {

  public HashMap<String, Object> findComponentCount(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> findComponent(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> removeComponent(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }
}
