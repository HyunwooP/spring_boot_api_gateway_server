package com.awakelife93.apigateway.service.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;

public interface CommonService {

  public Map<String, Object> getClientHealth(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getDesignHealth(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getDashboardCount(HttpServletRequest request) throws APIResponseException;

}
