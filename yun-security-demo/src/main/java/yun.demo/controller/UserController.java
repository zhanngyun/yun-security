package yun.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import yun.demo.dto.User;
import yun.demo.dto.UserQueryCondition;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yzhang
 * @date 2018/3/3 19:16
 * @desc
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping
    @JsonView(User.userNormal.class)
    public List<User> user(UserQueryCondition userQueryCondition,
                           @PageableDefault(size = 2,page = 1,sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        System.out.println(ReflectionToStringBuilder.toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getSort());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        List<User> list = new ArrayList<>();
        list.add(new User("username1","password1"));
        list.add(new User("username2","password2"));
        list.add(new User("username3","password3"));
        return list;
    }


    /**
     *
     * @param id 可以使用正则表达式来规定传过来的格式
     * @return
     */
    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.userDetail.class)
    public User getInfo(@PathVariable(required = false) String id){
        User user = new User();
        user.setPassword("password1");
        user.setUsername("tom");
        return user;
    }

    @PostMapping
    @JsonView(User.userNormal.class)
    public User create(@Valid @RequestBody UserQueryCondition queryCondition){

        System.out.println(ReflectionToStringBuilder.toString(queryCondition,ToStringStyle.MULTI_LINE_STYLE));
        User user = new User();
        user.setId(1);
        user.setDate(queryCondition.getDate());
        return user;
    }

    @PutMapping("/{id}")
    @JsonView(User.userNormal.class)
    public User edit(@Valid @RequestBody UserQueryCondition queryCondition, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().stream().forEach(e ->{
                FieldError fieldError = (FieldError)e;
                System.out.println(fieldError.getField()+":"+fieldError.getDefaultMessage());
            });
        }
        System.out.println(ReflectionToStringBuilder.toString(queryCondition,ToStringStyle.MULTI_LINE_STYLE));
        User user = new User();
        user.setId(1);
        user.setDate(queryCondition.getDate());
        return user;
    }
}
