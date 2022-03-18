package proj.gateway.apigateway.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.component.utils.HttpUtils;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.CommonModelService;

@RestController
@RequiredArgsConstructor
public class CommonModelController {

  private final CommonModelService commonModelService;

  @GetMapping(value = "/clientHealth")
  public String clientHealth(HttpServletRequest request, HttpServletResponse response) throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = commonModelService.clientHealth(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/designHealth")
  public String designHealth(HttpServletRequest request, HttpServletResponse response) throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = commonModelService.designHealth(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findDashboardCount")
  public String findDashboardCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = commonModelService.findDashboardCount(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
