package proj.gateway.apigateway.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

  @Bean
  public RestTemplate restTemplate() {
    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    HttpClient httpClient = HttpClientBuilder.create()
        .setMaxConnTotal(50)
        .setMaxConnPerRoute(20).build();

    factory.setReadTimeout(5000);
    factory.setConnectTimeout(3000);
    factory.setHttpClient(httpClient);

    RestTemplate restTemplate = new RestTemplate(factory);

    return restTemplate;
  }
}