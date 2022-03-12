package proj.gateway.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import proj.gateway.apigateway.common.component.Interceptor;

@Configuration
public class ProtocolConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    final String reactClientUrl = "http://localhost:3000";
    final String reactAdminUrl = "http://localhost:3003";

    registry.addMapping("/**").allowedOrigins(reactClientUrl, reactAdminUrl).allowedMethods("GET",
        "PUT", "DELETE", "POST", "PATCH");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new Interceptor()).addPathPatterns("/**");
  }
}
