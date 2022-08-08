package com.awakelife93.apigateway.common.component.utils;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Convert {

  public String objectToJsonString(Map<String, Object> params) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String jsonParams = mapper.writeValueAsString(params);

    return jsonParams;
  }

  public Map<String, Object> jsonStringToObject(String param) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();

    TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
    };

    Map<String, Object> map = mapper.readValue(param, typeRef);

    return map;
  }
}
