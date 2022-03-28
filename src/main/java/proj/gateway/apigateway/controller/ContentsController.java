package proj.gateway.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.ContentsService;

@RestController
@RequiredArgsConstructor
public class ContentsController {

  private final ContentsService contentsService;

  @GetMapping(value = "/findContentsCount")
  public Map<String, Object> findContentsCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return contentsService.findContentsCount(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findContents")
  public Map<String, Object> findContents(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return contentsService.findContents(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @PostMapping(value = "/createContents")
  public Map<String, Object> createContents(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body)
      throws APIResponseException {
    try {
      return contentsService.createContents(request, body);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @PatchMapping(value = "/updateContents")
  public Map<String, Object> updateContents(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body)
      throws APIResponseException {
    try {
      return contentsService.updateContents(request, body);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @DeleteMapping(value = "/removeContents")
  public Map<String, Object> removeContents(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return contentsService.removeContents(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
