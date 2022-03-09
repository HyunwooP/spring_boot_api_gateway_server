package proj.gateway.apigateway.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import proj.gateway.apigateway.common.service.CommonService;

@Service("AuthService")
public class AuthService extends CommonService {

  public HashMap<String, Object> signInUser(HttpServletRequest request, Map<String, Object> body) throws Exception {
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return bodyRequest(path, method, token, body);
  }

  public HashMap<String, Object> signInAdmin(HttpServletRequest request, Map<String, Object> body) throws Exception {
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return bodyRequest(path, method, token, body);
  }

  public HashMap<String, Object> signOut(HttpServletRequest request, Map<String, Object> body) throws Exception {
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return bodyRequest(path, method, token, body);
  }

  public HashMap<String, Object> signUp(HttpServletRequest request, Map<String, Object> body) throws Exception {
    String path = request.getRequestURI();
    String method = request.getMethod();
    String token = request.getHeader("authorization");

    return bodyRequest(path, method, token, body);
  }
}
