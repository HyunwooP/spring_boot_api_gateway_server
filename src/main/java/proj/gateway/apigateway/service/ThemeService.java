package proj.gateway.apigateway.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import proj.gateway.apigateway.common.service.CommonService;

@Service("ThemeService")
public class ThemeService extends CommonService {

  public HashMap<String, Object> findThemeCount(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> findThemeItem(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> findTheme(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> removeTheme(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }
}
