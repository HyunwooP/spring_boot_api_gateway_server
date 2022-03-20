package proj.gateway.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    final String reactClientUrl = "http://localhost:4000";
    final String reactAdminUrl = "http://localhost:4005";

    registry.addMapping("/**")
        .allowedOrigins(reactClientUrl, reactAdminUrl)
        .allowedMethods(
            HttpMethod.GET.name(),
            HttpMethod.PUT.name(),
            HttpMethod.DELETE.name(),
            HttpMethod.POST.name(),
            HttpMethod.PATCH.name());
  }
}
