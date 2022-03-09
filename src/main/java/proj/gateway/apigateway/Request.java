package proj.gateway.apigateway;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
// Http Request Utils
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import proj.gateway.apigateway.controller.RequestController;

/**
 * Main 객체 클라이언트의 모든 요청을 받아, API별 맞는 도메인에 내려준다.
 */
@RestController
public class Request {
  HashMap<String, Object> response;

  @Resource(name = "RequestController")
  private RequestController requestController;

  private String send(HttpServletResponse res) {
    int status = (int) response.get("status");
    String jsonString = (String) response.get("data");

    res.setStatus(status);
    return jsonString;
  };

  @RequestMapping(value = { "/{path}", "/{path}/" }, method = RequestMethod.GET)
  private String get(HttpServletRequest req, HttpServletResponse res) throws Exception {
    response = requestController.get(req);
    return send(res);
  }

  @RequestMapping(value = { "/{path}", "/{path}/" }, method = RequestMethod.DELETE)
  private String delete(HttpServletRequest req, HttpServletResponse res) throws Exception {
    response = requestController.delete(req);
    return send(res);
  }

  @RequestMapping(value = { "/{path}" }, method = RequestMethod.POST)
  private String post(HttpServletRequest req, HttpServletResponse res, @RequestBody Map<String, Object> body)
      throws Exception {
    response = requestController.post(req, body);
    return send(res);
  }

  @RequestMapping(value = { "/{path}" }, method = RequestMethod.PUT)
  private String put(HttpServletRequest req, HttpServletResponse res, @RequestBody Map<String, Object> body)
      throws Exception {
    response = requestController.put(req, body);
    return send(res);
  }

  @RequestMapping(value = { "/{path}" }, method = RequestMethod.PATCH)
  private String patch(HttpServletRequest req, HttpServletResponse res, @RequestBody Map<String, Object> body)
      throws Exception {
    response = requestController.patch(req, body);
    return send(res);
  }
}
