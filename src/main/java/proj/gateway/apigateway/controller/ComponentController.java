package proj.gateway.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.ComponentService;

@RestController
@RequiredArgsConstructor
public class ComponentController {

  private final ComponentService componentService;

  @GetMapping(value = "/findComponentCount")
  public Map<String, Object> findComponentCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return componentService.findComponentCount(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findComponent")
  public Map<String, Object> findComponent(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return componentService.findComponent(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @DeleteMapping(value = "removeComponent")
  public Map<String, Object> removeComponent(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return componentService.removeComponent(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
