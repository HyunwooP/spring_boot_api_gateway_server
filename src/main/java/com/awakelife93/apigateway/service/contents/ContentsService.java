package com.awakelife93.apigateway.service.contents;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;

public interface ContentsService {

  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getContent(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getContents(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> create(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException;

  public Map<String, Object> update(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException;

  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException;

}
