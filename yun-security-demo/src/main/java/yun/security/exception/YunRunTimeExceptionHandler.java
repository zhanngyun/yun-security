package yun.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yzhang
 * @date 2018/3/4 14:25
 * @desc
 */
@ControllerAdvice
public class YunRunTimeExceptionHandler {


    @ExceptionHandler(YunRunTimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handleException(YunRunTimeException ex){
        Map<String,Object> map = new HashMap<>();
        map.put("id",ex.getId());
        map.put("message",ex.getMessage());
        return map;
    }
}
