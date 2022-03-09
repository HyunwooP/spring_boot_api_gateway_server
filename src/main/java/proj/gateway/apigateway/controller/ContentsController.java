package proj.gateway.apigateway.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import proj.gateway.apigateway.service.ContentsService;

@Controller("ContentsController")
public class ContentsController {

  @Resource(name = "ContentsService")
  private ContentsService contentsService;

  public HashMap<String, Object> findContentsCount(HttpServletRequest request) throws Exception {
    return contentsService.findContentsCount(request);
  }

  public HashMap<String, Object> findContents(HttpServletRequest request) throws Exception {
    return contentsService.findContents(request);
  }

  public HashMap<String, Object> createContents(HttpServletRequest request, Map<String, Object> body) throws Exception {
    return contentsService.createContents(request, body);
  }

  public HashMap<String, Object> updateContents(HttpServletRequest request, Map<String, Object> body) throws Exception {
    return contentsService.updateContents(request, body);
  }

  public HashMap<String, Object> removeContents(HttpServletRequest request) throws Exception {
    return contentsService.removeContents(request);
  }
}
