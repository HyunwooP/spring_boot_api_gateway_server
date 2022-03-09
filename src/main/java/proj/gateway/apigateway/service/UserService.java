package proj.gateway.apigateway.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import proj.gateway.apigateway.common.service.CommonService;

@Service("UserService")
public class UserService extends CommonService {

  public HashMap<String, Object> findUser(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> findUserCount(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> findUserProfile(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> updateUser(HttpServletRequest request, Map<String, Object> body) throws Exception {
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return bodyRequest(path, method, token, body);
  }

  public HashMap<String, Object> removeUser(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }

  public HashMap<String, Object> tokenRemoveUser(HttpServletRequest request) throws Exception {
    String queryString = request.getQueryString();
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return queryRequest(queryString, path, method, token);
  }
}
