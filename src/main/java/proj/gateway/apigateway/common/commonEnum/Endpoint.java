package proj.gateway.apigateway.common.commonEnum;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Endpoint {

  public static Map<String, String> getApiServerEndpoints() {
    Map<String, String> enumMap = new HashMap<String, String>();

    for (ApiServerEndpoints endpoint : ApiServerEndpoints.values()) {
      enumMap.put(endpoint.name(), "/" + endpoint.toString());
    }

    return enumMap;
  }

  public static Map<String, String> getDesignServerEndpoints() {
    Map<String, String> enumMap = new HashMap<String, String>();

    for (DesignServerEndpoints endpoint : DesignServerEndpoints.values()) {
      enumMap.put(endpoint.name(), "/" + endpoint.toString());
    }

    return enumMap;
  }

  // Node Api Server
  public enum ApiServerEndpoints {
    findUser, findUserProfile, findUserCount, findContents, findContentsCount, signInUser, signInAdmin, signOut, signUp,
    removeUser, tokenRemoveUser, updateUser, createContents, updateContents, findDashboardCount, clientHealth
  }

  // Design Server
  public enum DesignServerEndpoints {
    findThemeItem, findComponent, findLayout, findStyle, findTheme, findComponentCount, findLayoutCount, findStyleCount,
    findThemeCount, removeComponent, removeLayout, removeStyle, removeTheme, designHealth
  }
}
