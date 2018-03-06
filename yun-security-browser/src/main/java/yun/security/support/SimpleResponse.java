package yun.security.support;

/**
 * @Author: yzhang
 * @Date: 2018/3/6 16:32
 */
public class SimpleResponse {
    private Object content;


    public SimpleResponse(Object content){
        this.content = content;
    }


    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
