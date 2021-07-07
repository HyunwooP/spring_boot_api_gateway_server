package proj.gateway.apigateway.common.error;

import java.util.HashMap;
import javax.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Error Handler
 */
@RestControllerAdvice
public class ErrorHandler {

  // Client에 던질 멤버변수
  private HashMap<String, Object> returnMap;
  // Node 서버들의 에러를 init
  private HashMap<Integer, String> errorMap;

  @PostConstruct
  private void init() {
    /**
     * Node Error List UNAUTHORIZED = 401 FORBIDDEN = 403 NOT_FOUND = 404 BAD_REQUEST = 400
     * DUPLICATE = 409 INTERNAL_SERVER_ERROR = 500
     */
    errorMap = new HashMap<Integer, String>();
    errorMap.put(401, "UNAUTHORIZED");
    errorMap.put(403, "FORBIDDEN");
    errorMap.put(404, "NOT_FOUND");
    errorMap.put(400, "BAD_REQUEST");
    errorMap.put(409, "DUPLICATE");
    errorMap.put(500, "INTERNAL_SERVER_ERROR");
  }

  /**
   * errorHandler
   * 
   * @param e
   * @return
   */
  @ExceptionHandler(Exception.class)
  private ResponseEntity<Object> errorHandler(Exception e) {
    // ex: Server returned HTTP response code: 403 for URL: http://localhost:3001/findUserProfile
    String[] error = e.getMessage().split(" ");
    // ex: 403
    int code = Integer.parseInt(error[5]);

    returnMap = new HashMap<String, Object>();
    returnMap.put("status", code);
    returnMap.put("message", errorMap.get(code));

    return ResponseEntity.status(code).body(returnMap);
  }
}
