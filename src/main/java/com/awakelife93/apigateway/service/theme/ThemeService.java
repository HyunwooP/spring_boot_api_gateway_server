package com.awakelife93.apigateway.service.theme;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;

public interface ThemeService {

  public Map<String, Object> getCount(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getThemeItem(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getTheme(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> getThemes(HttpServletRequest request) throws APIResponseException;

  public Map<String, Object> remove(HttpServletRequest request) throws APIResponseException;

}
