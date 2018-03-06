package yun.security.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author yzhang
 * @date 2018/3/4 13:36
 * @desc
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    //在这里可以使用 @AutoWired注解 引用其他的服务，上面不需要添加@Component注解


    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println("joining....");
        return false;
    }
}
