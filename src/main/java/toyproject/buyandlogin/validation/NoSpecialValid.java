package toyproject.buyandlogin.validation;

import javax.validation.Constraint;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = NoSpecialValidator.class)
public @interface NoSpecialValid {
    String message() default "특수문자 및 숫자 입력 불가 입니다.";
    Class[] groups() default {};
    Class[] payload() default {};
}
