package proj.gateway.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import proj.gateway.apigateway.common.component.Interceptor;

@Configuration
public class ProtocolConfig implements WebMvcConfigurer {

  // todo = 3000, 3001, 3002 각 도메인들 한곳으로 따놓기
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedOrigins("http://localhost:3000", "http://localhost:3003").allowedMethods("GET",
        "PUT", "DELETE", "POST", "PATCH");
  }

  @Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new Interceptor()).addPathPatterns("/**");
	}
}
