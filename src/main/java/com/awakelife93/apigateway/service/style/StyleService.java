package com.awakelife93.apigateway.service.style;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;

public interface StyleService {

  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getStyle(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getStyles(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException;

}
