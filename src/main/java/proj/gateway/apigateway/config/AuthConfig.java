package proj.gateway.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.component.AuthInterceptor;

@Configuration
@RequiredArgsConstructor
public class AuthConfig implements WebMvcConfigurer {

  private final AuthInterceptor authInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authInterceptor).addPathPatterns("/signOut", "/findDashboardCount", "/findContentsCount",
        "/createContents", "/updateContents", "/removeContents", "/findUser", "/findUserCount", "/findUserProfile",
        "/updateUser", "/removeUser", "/tokenRemoveUser");
  }
}
