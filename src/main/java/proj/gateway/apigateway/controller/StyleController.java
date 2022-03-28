package proj.gateway.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.StyleService;

@RestController
@RequiredArgsConstructor
public class StyleController {

  private final StyleService styleService;

  @GetMapping(value = "/findStyleCount")
  public Map<String, Object> findStyleCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return styleService.findStyleCount(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findStyle")
  public Map<String, Object> findStyle(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return styleService.findStyle(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @DeleteMapping(value = "/removeStyle")
  public Map<String, Object> removeStyle(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return styleService.removeStyle(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
