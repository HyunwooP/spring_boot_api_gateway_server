package com.awakelife93.apigateway.controller;

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

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.service.contents.ContentsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("contents")
@RequiredArgsConstructor
public class ContentsController {

  private final ContentsService contentsService;

  @GetMapping("count")
  public Map<String, Object> getCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return contentsService.getCount(request);
  }

  @GetMapping("{contentId}")
  public Map<String, Object> getContent(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return contentsService.getContent(request);
  }

  @GetMapping()
  public Map<String, Object> getContents(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    return contentsService.getContents(request);
  }

  @PostMapping()
  public Map<String, Object> create(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body)
      throws APIResponseException {
    return contentsService.create(request, body);
  }

  @PatchMapping("{contentId}")
  public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body)
      throws APIResponseException {
    return contentsService.update(request, body);
  }

  @DeleteMapping("{contentId}")
  public Map<String, Object> remove(HttpServletRequest request)
      throws APIResponseException {
    return contentsService.remove(request);
  }
}
