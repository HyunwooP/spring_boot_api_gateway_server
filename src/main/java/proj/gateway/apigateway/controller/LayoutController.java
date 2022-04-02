package proj.gateway.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.LayoutService;

@RestController
@RequestMapping("/layouts")
@RequiredArgsConstructor
public class LayoutController {

  private final LayoutService layoutService;

  @GetMapping("/count")
  public Map<String, Object> getCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return layoutService.getCount(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping("/{layoutId}")
  public Map<String, Object> getLayout(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return layoutService.getLayout(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping()
  public Map<String, Object> getLayouts(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return layoutService.getLayouts(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @DeleteMapping("/{layoutId}")
  public Map<String, Object> remove(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return layoutService.remove(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
