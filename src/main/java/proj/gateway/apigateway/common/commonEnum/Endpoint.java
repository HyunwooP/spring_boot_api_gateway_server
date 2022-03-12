package proj.gateway.apigateway.common.commonEnum;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Endpoint {

  public static Map<String, String> getApiServerEndPoints() {
    Map<String, String> enumMap = new HashMap<String, String>();

    for (ApiServerEndPoints endpoint : ApiServerEndPoints.values()) {
      enumMap.put(endpoint.name(), "/" + endpoint.toString());
    }

    return enumMap;
  }

  public static Map<String, String> getDesignServerEndPoints() {
    Map<String, String> enumMap = new HashMap<String, String>();

    for (DesignServerEndPoints endpoint : DesignServerEndPoints.values()) {
      enumMap.put(endpoint.name(), "/" + endpoint.toString());
    }

    return enumMap;
  }

  public static Map<String, String> getCertificateEndPoints() {
    Map<String, String> enumMap = new HashMap<String, String>();

    for (CertificateEndPoints endpoint : CertificateEndPoints.values()) {
      enumMap.put(endpoint.name(), "/" + endpoint.toString());
    }

    return enumMap;
  }

  private static enum ApiServerEndPoints {
    findUser, findUserProfile, findUserCount, findContents, findContentsCount, signInUser, signInAdmin, signOut, signUp,
    removeUser, tokenRemoveUser, updateUser, createContents, updateContents, findDashboardCount, clientHealth
  }

  private static enum DesignServerEndPoints {
    findThemeItem, findComponent, findLayout, findStyle, findTheme, findComponentCount, findLayoutCount, findStyleCount,
    findThemeCount, removeComponent, removeLayout, removeStyle, removeTheme, designHealth
  }

  private static enum CertificateEndPoints {
    signOut, findDashboardCount, findContentsCount, createContents, updateContents, removeContents, findUser,
    findUserCount, findUserProfile, updateUser, removeUser, tokenRemoveUser
  }
}
