package proj.gateway.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    final String reactClientUrl = "http://localhost:3000";
    final String reactAdminUrl = "http://localhost:3003";

    registry.addMapping("/**").allowedOrigins(reactClientUrl, reactAdminUrl).allowedMethods("GET",
        "PUT", "DELETE", "POST", "PATCH");
  }
}
