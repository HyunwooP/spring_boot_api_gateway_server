package proj.gateway.apigateway.common.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import proj.gateway.apigateway.common.error.exceptions.NotCertificateException;
import proj.gateway.apigateway.common.utils.CertificateUtils;

@Component
public class Interceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws NotCertificateException {
    String path = request.getRequestURI();
    String token = request.getHeader("authorization");

    if (!CertificateUtils.certificate(token, path)) {
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
