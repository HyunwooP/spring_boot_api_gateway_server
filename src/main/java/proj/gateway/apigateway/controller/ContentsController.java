package proj.gateway.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import proj.gateway.apigateway.common.error.exceptions.APIResponseException;
import proj.gateway.apigateway.service.ContentsService;

@RestController
@RequestMapping("/contents")
@RequiredArgsConstructor
public class ContentsController {

  private final ContentsService contentsService;

  @GetMapping("/count")
  public Map<String, Object> getCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return contentsService.getCount(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/{contentId}")
  public Map<String, Object> getContent(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return contentsService.getContent(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping()
  public Map<String, Object> getContents(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      return contentsService.getContents(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @PostMapping()
  public Map<String, Object> create(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body)
      throws APIResponseException {
    try {
      return contentsService.create(request, body);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @PatchMapping("/{contentId}")
  public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body)
      throws APIResponseException {
    try {
      return contentsService.update(request, body);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @DeleteMapping("/{contentId}")
  public Map<String, Object> remove(HttpServletRequest request)
      throws APIResponseException {
    try {
      return contentsService.remove(request);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}
