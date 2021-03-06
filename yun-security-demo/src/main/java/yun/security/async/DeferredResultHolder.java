package yun.security.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yzhang
 * @date 2018/3/4 22:44
 * @desc
 */
@Component
public class DeferredResultHolder {

    private Map<String,DeferredResult<String>> map  = new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}
