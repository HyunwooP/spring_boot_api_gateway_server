package com.awakelife93.apigateway.service.auth;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;

public interface AuthService {

        public Map<String, Object> signIn(HttpServletRequest request, Map<String, Object> body)
                        throws APIResponseException;

        public Map<String, Object> signOut(HttpServletRequest request, Map<String, Object> body)
                        throws APIResponseException;

}
