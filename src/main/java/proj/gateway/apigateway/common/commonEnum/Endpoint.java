package proj.gateway.apigateway.common.commonEnum;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * Endpoint Enum
 */
@Component
public class Endpoint {

  /**
   * API 서버의 endpoint -> Map
   * 
   * @return
   */
  public static Map<String, String> getApiServerEndpoints() {
    Map<String, String> enumMap = new HashMap<String, String>();

    for (ApiServerEndpoints endpoint : ApiServerEndpoints.values()) {
      enumMap.put(endpoint.name(), "/" + endpoint.toString());
    }

    return enumMap;
  }


  /**
   * Design 서버의 endpoint -> Map
   * 
   * @return
   */
  public static Map<String, String> getDesignServerEndpoints() {
    Map<String, String> enumMap = new HashMap<String, String>();

    for (DesignServerEndpoints endpoint : DesignServerEndpoints.values()) {
      enumMap.put(endpoint.name(), "/" + endpoint.toString());
    }

    return enumMap;
  }

  // Node Api Server
  public enum ApiServerEndpoints {
    findUser, findUserProfile, findUserCount, findContents, findContentsCount, signInUser, signInAdmin, signOut, signUp, removeUser, updateUser, findDashboardCount
  }

  // Design Server
  public enum DesignServerEndpoints {
    findThemeItem, findComponent, findLayout, findStyle, findTheme, findComponentCount, findLayoutCount, findStyleCount, findThemeCount
  }
}
