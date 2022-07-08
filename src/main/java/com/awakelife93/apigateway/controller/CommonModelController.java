package com.awakelife93.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.service.CommonModelService;

@RestController
@RequiredArgsConstructor
public class CommonModelController {

  private final CommonModelService commonModelService;

  @GetMapping("clientHealth")
  public Map<String, Object> getClientHealth(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return commonModelService.getClientHealth(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping("designHealth")
  public Map<String, Object> getDesignHealth(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return commonModelService.getDesignHealth(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping("dashboardCount")
  public Map<String, Object> getDashboardCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return commonModelService.getDashboardCount(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
