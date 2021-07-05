package proj.gateway.apigateway;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import proj.gateway.apigateway.controller.GetController;


@RestController
@RequestMapping()
public class Request {
  @Autowired
  GetController getController;

  @RequestMapping(value = {"/{path}", "/{path}/"}, method = RequestMethod.GET)
  public String get(@PathVariable String path, @RequestParam Map<String, String> allRequestParams)
      throws Exception {
    return getController.reqeust(path, allRequestParams);
  }

  // todo = 다른 Method 작성하기
}
