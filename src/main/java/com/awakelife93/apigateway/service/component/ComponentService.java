package com.awakelife93.apigateway.service.component;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;

public interface ComponentService {

  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getComponent(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getComponents(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException;

}
