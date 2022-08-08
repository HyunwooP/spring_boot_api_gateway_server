package com.awakelife93.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.service.common.CommonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommonController {

  private final CommonService commonService;

  @GetMapping("clientHealth")
  public Map<String, Object> getClientHealth(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return commonService.getClientHealth(request);
  }

  @GetMapping("designHealth")
  public Map<String, Object> getDesignHealth(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return commonService.getDesignHealth(request);
  }

  @GetMapping("dashboardCount")
  public Map<String, Object> getDashboardCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return commonService.getDashboardCount(request);
  }
}
