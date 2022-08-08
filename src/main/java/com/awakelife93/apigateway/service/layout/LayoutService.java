package com.awakelife93.apigateway.service.layout;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;

public interface LayoutService {

  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getLayout(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getLayouts(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException;

}
