package proj.gateway.apigateway.common.error;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Error Handler
 */
@EnableWebMvc
@RestControllerAdvice
public class ErrorHandler {

  // Client에 던질 멤버변수
  private HashMap<String, Object> returnMap = new HashMap<String, Object>();
  // Node 서버들의 에러를 init
  private HashMap<Integer, String> errorMap = new HashMap<Integer, String>();

  @PostConstruct
  private void init() {
    /**
     * Node Error List UNAUTHORIZED = 401 FORBIDDEN = 403 NOT_FOUND = 404
     * BAD_REQUEST = 400 DUPLICATE = 409 INTERNAL_SERVER_ERROR = 500
     */
    errorMap.put(401, "UNAUTHORIZED");
    errorMap.put(403, "FORBIDDEN");
    errorMap.put(404, "NOT_FOUND");
    errorMap.put(400, "BAD_REQUEST");
    errorMap.put(409, "DUPLICATE");
    errorMap.put(500, "INTERNAL_SERVER_ERROR");
  }

  private int getErrorCode(String[] messageArray) {

    if (messageArray[0].equals("CircuitBreaker")) {
      return 429;
    }

    if (messageArray.length < 2) {
      // Node Server에서 404를 리턴할 경우, Spring에서 FindNotFoundException으로 Catch하기 때문에 따로
      // 404처리
      return 404;
    } else {
      return Integer.parseInt(messageArray[5]);
    }
  }

  // 해당 메소드를 통해서 원초적인 에러 메세지를 얻을지 상태 에러 메세지를 얻을지 결정
  private boolean checkGetErrorMessage(int code) {
    if (code == 429)
      return false;
    return true;
  }

  private String getErrorMessage(int code) {
    return errorMap.get(code);
  }

  /**
   * errorHandler
   *
   * @param e
   * @return
   */
  @ExceptionHandler(Exception.class)
  private ResponseEntity<Object> errorHandler(Exception e) {
    // ex: Server returned HTTP response code: 403 for URL:
    // http://localhost:3001/findUserProfile
    String errorMessage = e.getMessage();
    String[] messageArray = errorMessage.split(" ");
    int code = getErrorCode(messageArray);
    String message = checkGetErrorMessage(code) ? getErrorMessage(code) : errorMessage;

    System.out.println("===========");
    System.out.println(errorMessage);
    System.out.println("===========");

    returnMap.put("status", code);
    returnMap.put("message", message);

    return ResponseEntity.status(code).body(returnMap);
  }
}
