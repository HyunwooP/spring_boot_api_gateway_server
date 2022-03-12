package proj.gateway.apigateway.common.utils;

import java.util.Map;

import proj.gateway.apigateway.common.commonEnum.Endpoint;

public class CertificateUtils {

  public static boolean certificate(String token, String path) {
    Map<String, String> CertificateEndPoints = Endpoint.getCertificateEndPoints();

    if (CertificateEndPoints.containsValue(path)) {
      if (token == null) {
        return false;
      }
    }

    return true;
  }
}
