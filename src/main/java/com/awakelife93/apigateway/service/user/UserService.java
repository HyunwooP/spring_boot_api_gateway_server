package com.awakelife93.apigateway.service.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;

public interface UserService {

  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getUser(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getUsers(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getProfile(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> create(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException;

  public Map<String, Object> update(HttpServletRequest request, Map<String, Object> body)
      throws APIResponseException;

  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> tokenRemove(HttpServletRequest request) throws APIResponseException;

}
