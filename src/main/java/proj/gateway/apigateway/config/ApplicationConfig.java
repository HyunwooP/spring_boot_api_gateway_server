package proj.gateway.apigateway.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class ApplicationConfig {

  @Resource
  void configureDispatcherServlet(DispatcherServlet dispatcherServlet) {
    dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
  }
}
