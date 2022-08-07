package com.awakelife93.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;
import com.awakelife93.apigateway.common.component.AuthInterceptor;

@Configuration
@RequiredArgsConstructor
public class AuthConfig implements WebMvcConfigurer {

  private final AuthInterceptor authInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authInterceptor).addPathPatterns(
        "/auth/signOut",
        "/dashboardCount",
        "/clientHealth",
        "/designHealth",
        "/contents/count",
        "/contents/{contentId}",
        "/users",
        "/users/{userId}",
        "/users/count",
        "/users/profile",
        "/users/tokenRemove");
  }
}
