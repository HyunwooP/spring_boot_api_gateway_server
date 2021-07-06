package proj.gateway.apigateway.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import proj.gateway.apigateway.service.PostService;

/**
 * Post 컨트롤러
 */
@Controller
public class PostController {
  @Autowired
  private PostService postService;

  public String reqeust(String path, Map<String, String> params) throws Exception {
    return postService.response(path, params);
  }
}
