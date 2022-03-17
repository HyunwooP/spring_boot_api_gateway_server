package proj.gateway.apigateway.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.common.utils.HttpUtils;
import proj.gateway.apigateway.service.ComponentService;

@RestController
@RequiredArgsConstructor
public class ComponentController {

  private final ComponentService componentService;

  @GetMapping(value = "/findComponentCount")
  public String findComponentCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = componentService.findComponentCount(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findComponent")
  public String findComponent(HttpServletRequest request, HttpServletResponse response) throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = componentService.findComponent(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @DeleteMapping(value = "removeComponent")
  public String removeComponent(HttpServletRequest request, HttpServletResponse response) throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = componentService.removeComponent(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
