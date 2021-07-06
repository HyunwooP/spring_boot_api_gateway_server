package proj.gateway.apigateway;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
// Http Request Utils
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Controllers
import proj.gateway.apigateway.controller.DeleteController;
import proj.gateway.apigateway.controller.GetController;
import proj.gateway.apigateway.controller.PatchController;
import proj.gateway.apigateway.controller.PostController;
import proj.gateway.apigateway.controller.PutController;

/**
 * Main 객체 클라이언트의 모든 요청을 받아, API별 맞는 도메인에 내려준다.
 */
@RestController
public class Request {

  @Autowired
  GetController getController;

  @Autowired
  PostController postController;

  @Autowired
  DeleteController deleteController;

  @Autowired
  PutController putController;

  @Autowired
  PatchController patchController;


  @RequestMapping(value = {"/{path}", "/{path}/"}, method = RequestMethod.GET)
  private String get(@PathVariable String path, @RequestParam Map<String, String> allRequestParams)
      throws Exception {
    return getController.reqeust(path, allRequestParams);
  }

  @RequestMapping(value = {"/{path}", "/{path}/"}, method = RequestMethod.DELETE)
  private String delete(@PathVariable String path,
      @RequestParam Map<String, String> allRequestParams) throws Exception {
    return deleteController.reqeust(path, allRequestParams);
  }

  @RequestMapping(value = {"/{path}"}, method = RequestMethod.POST)
  private String post(@PathVariable String path, @RequestBody Map<String, String> allRequestParams)
      throws Exception {
    return postController.reqeust(path, allRequestParams);
  }

  @RequestMapping(value = {"/{path}"}, method = RequestMethod.PUT)
  private String put(@PathVariable String path, @RequestBody Map<String, String> allRequestParams)
      throws Exception {
    return putController.reqeust(path, allRequestParams);
  }

  @RequestMapping(value = {"/{path}"}, method = RequestMethod.PATCH)
  private String patch(@PathVariable String path, @RequestBody Map<String, String> allRequestParams)
      throws Exception {
    return patchController.reqeust(path, allRequestParams);
  }
}
