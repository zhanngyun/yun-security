package yun.demo.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author yzhang
 * @date 2018/3/3 19:30
 * @desc
 */
public class UserQueryCondition {

    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
    private Integer age;
    private String ageTo;
    private String xxxx;

    @Past(message = "生日不能为过去的日期")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(String ageTo) {
        this.ageTo = ageTo;
    }

    public String getXxxx() {
        return xxxx;
    }

    public void setXxxx(String xxxx) {
        this.xxxx = xxxx;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
