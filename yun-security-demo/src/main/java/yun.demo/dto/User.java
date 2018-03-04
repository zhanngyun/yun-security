package yun.demo.dto;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;

/**
 * @author yzhang
 * @date 2018/3/3 19:19
 * @desc
 */


public class User {

    public interface userNormal{}

    public interface userDetail extends userNormal{}

    @JsonView(userNormal.class)
    private Integer id;

    @JsonView(userNormal.class)
    private String username;

    @JsonView(userDetail.class)
    private String password;

    @JsonView(userNormal.class)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
