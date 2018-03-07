package yun.security.properties;

/**
 * @Author: yzhang
 * @Date: 2018/3/7 14:20
 */
public class ImageCodeProperties {

    /**
     * 宽度
     */
    private int width = 67;
    /**
     * 高度
     */
    private int height = 23;
    /**
     * 位数
     */
    private int length = 4;
    /**
     * 失效时间
     */
    private int expireIn = 60;

    /**
     * 适配地址
     */
    private String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
}
