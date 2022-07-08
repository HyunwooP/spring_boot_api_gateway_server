package com.awakelife93.apigateway.common.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.awakelife93.apigateway.common.error.exceptions.NotCertificateException;

@Component
public class AuthInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws NotCertificateException {
    String token = request.getHeader("authorization");
    String method = request.getMethod();

    // options method로 들어오면 그냥 무조건 통과...
    if (method.equals(HttpMethod.OPTIONS.name())) {
      return true;
    }

    if (token == null || token.isBlank()) {
      throw new NotCertificateException();
    }

    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
      Exception exception)
      throws Exception {
  }
}
