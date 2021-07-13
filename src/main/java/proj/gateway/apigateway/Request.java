package proj.gateway.apigateway;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

  @Resource(name = "requestController")
  private RequestController requestController;

  @RequestMapping(value = {"/{path}", "/{path}/"}, method = RequestMethod.GET)
  private String get(HttpServletRequest req, HttpServletResponse res) throws Exception {
    HashMap<String, Object> response = requestController.getReqeust(req);

    int status = (int) response.get("status");
    String jsonString = (String) response.get("data");

    res.setStatus(status);
    return jsonString;
  }

  @RequestMapping(value = {"/{path}", "/{path}/"}, method = RequestMethod.DELETE)
  private String delete(HttpServletRequest req, HttpServletResponse res) throws Exception {
    HashMap<String, Object> response = requestController.deleteReqeust(req);

    int status = (int) response.get("status");
    String jsonString = (String) response.get("data");

    res.setStatus(status);
    return jsonString;
  }

  @RequestMapping(value = {"/{path}"}, method = RequestMethod.POST)
  private String post(@PathVariable String path, @RequestBody Map<String, String> allRequestParams,
      @RequestHeader Map<String, String> header) throws Exception {
    return requestController.postReqeust(path, allRequestParams, header);
  }

  @RequestMapping(value = {"/{path}"}, method = RequestMethod.PUT)
  private String put(@PathVariable String path, @RequestBody Map<String, String> allRequestParams,
      @RequestHeader Map<String, String> header) throws Exception {
    return requestController.putReqeust(path, allRequestParams, header);
  }

  @RequestMapping(value = {"/{path}"}, method = RequestMethod.PATCH)
  private String patch(@PathVariable String path, @RequestBody Map<String, String> allRequestParams,
      @RequestHeader Map<String, String> header) throws Exception {
    return requestController.patchReqeust(path, allRequestParams, header);
  }
}
