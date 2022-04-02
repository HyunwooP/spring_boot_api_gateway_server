package proj.gateway.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.ComponentService;

@RestController
@RequestMapping("/components")
@RequiredArgsConstructor
public class ComponentController {

  private final ComponentService componentService;

  @GetMapping("/count")
  public Map<String, Object> getCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return componentService.getCount(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping("{componentId}")
  public Map<String, Object> getComponent(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return componentService.getComponent(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping()
  public Map<String, Object> getComponents(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return componentService.getComponents(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @DeleteMapping("/{componentId}")
  public Map<String, Object> remove(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return componentService.remove(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
