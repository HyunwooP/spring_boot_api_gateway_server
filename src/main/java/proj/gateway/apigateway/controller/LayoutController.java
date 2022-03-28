package proj.gateway.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.LayoutService;

@RestController
@RequiredArgsConstructor
public class LayoutController {

  private final LayoutService layoutService;

  @GetMapping(value = "/findLayoutCount")
  public Map<String, Object> findLayoutCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return layoutService.findLayoutCount(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findLayout")
  public Map<String, Object> findLayout(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return layoutService.findLayout(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @DeleteMapping(value = "/removeLayout")
  public Map<String, Object> removeLayout(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return layoutService.removeLayout(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
