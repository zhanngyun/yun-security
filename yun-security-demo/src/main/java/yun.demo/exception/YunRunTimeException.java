package yun.demo.exception;

/**
 * @author yzhang
 * @date 2018/3/4 14:16
 * @desc 自定义异常
 */


public class YunRunTimeException extends RuntimeException{

    private Integer id;



    public YunRunTimeException(Integer id){
        super("user is not exist");
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
