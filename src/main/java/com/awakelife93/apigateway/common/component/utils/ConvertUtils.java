package com.awakelife93.apigateway.common.component.utils;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

@Component
public class ConvertUtils {

  public static String objectToJsonString(Map<String, Object> params) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String jsonParams = mapper.writeValueAsString(params);

    return jsonParams;
  }

  public static Map<String, String> jsonStringToObject(String param) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    Map<String, String> map = mapper.readValue(param, Map.class);

    return map;
  }
}
