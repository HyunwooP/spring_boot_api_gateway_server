package proj.gateway.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.CommonModelService;

@RestController
@RequiredArgsConstructor
public class CommonModelController {

  private final CommonModelService commonModelService;

  @GetMapping(value = "/clientHealth")
  public Map<String, Object> clientHealth(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return commonModelService.clientHealth(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/designHealth")
  public Map<String, Object> designHealth(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return commonModelService.designHealth(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findDashboardCount")
  public Map<String, Object> findDashboardCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return commonModelService.findDashboardCount(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
